/// ==========================
// ÉTAT GLOBAL
// ==========================
const TERM_TO_CODE = {
  winter: "H25",
  autumn: "A24",
  summer: "E24"
};


let courses = [];
const courseSet = [];
let visibleCount = 5;

// ==========================
// CHARGEMENT DES COURS
// ==========================
async function loadCourses() {
  try {
    const cached = localStorage.getItem("courses");
    if (cached) {
      courses = JSON.parse(cached);
      renderCourses();
      populateSelects();
      return;
    }

    const response = await fetch("/courses");
    courses = await response.json();
    localStorage.setItem("courses", JSON.stringify(courses));

    renderCourses();
    populateSelects();
  } catch (err) {
    console.error("Erreur chargement cours", err);
  }
}

// ==========================
// VOIR PLUS / MOINS
// ==========================
function affichermoinsdecours() {
  visibleCount = Math.max(5, visibleCount - 5);
  renderCourses();
}

function afficherplusdecours() {
  visibleCount += 5;
  renderCourses();
}

// ==========================
// AFFICHAGE + FILTRES
// ==========================
function renderCourses() {
  const container = document.getElementById("courses");
  const query = searchInput.value.toLowerCase();
  const term = termFilter.value;

  container.innerHTML = "";

  courses
    .filter(c => {
      const matchText =
        c.id.toLowerCase().includes(query) ||
        c.name.toLowerCase().includes(query) ||
        c.description.toLowerCase().includes(query);

      const matchTerm =
        term === "" || c.available_terms[term] === true;

      return matchText && matchTerm;
    })
    .slice(0, visibleCount)
    .forEach(c => {
  const div = document.createElement("div");
  div.className = "course";

  div.innerHTML = `
    <h3>${c.id}</h3>
    <p>${c.name}</p>
    <p>Crédits : ${c.credits}</p>
  `;

  div.style.cursor = "pointer";

 
  div.addEventListener("click", (e) => {
    e.preventDefault();
    e.stopPropagation();

    const selectedTerm = termFilter.value;
    const semesterCode = TERM_TO_CODE[selectedTerm] || "H25";

    window.location.href =
      `course.html?id=${c.id}&semester=${semesterCode}`;
  });

  container.appendChild(div);
});
}

// ==========================
// REMPLIR LES SELECTS
// ==========================
function populateSelects() {
  ["compare1", "compare2", "setSelect"].forEach(id => {
    const select = document.getElementById(id);
    if (!select) return;

    select.innerHTML = "";
    courses.forEach(c => {
      const opt = document.createElement("option");
      opt.value = c.id;
      opt.textContent = c.id;
      select.appendChild(opt);
    });
  });
}

// ==========================
// COMPARAISON DE COURS
// ==========================
function compareCourses() {
  const input = document
    .getElementById("compareInput")
    .value
    .toUpperCase()
    .split(",")
    .map(s => s.trim())
    .filter(Boolean);

  const result = document.getElementById("comparison");

  if (input.length < 2) {
    result.innerHTML =
      "<p>Veuillez entrer au moins deux sigles de cours.</p>";
    return;
  }

  const selectedCourses = input
    .map(code => courses.find(c => c.id === code))
    .filter(Boolean);

  if (selectedCourses.length < 2) {
    result.innerHTML =
      "<p>Erreur : au moins un sigle est invalide.</p>";
    return;
  }

  let html = `
    <h3>Comparaison des cours</h3>

    <table class="compare-table">
      <tr>
        <th>Sigle</th>
        ${selectedCourses.map(c => `<td>${c.id}</td>`).join("")}
      </tr>

      <tr>
        <th>Nom</th>
        ${selectedCourses.map(c => `<td>${c.name}</td>`).join("")}
      </tr>

      <tr>
        <th>Crédits</th>
        ${selectedCourses.map(c => `<td>${c.credits}</td>`).join("")}
      </tr>

      <tr>
        <th>Description</th>
        ${selectedCourses.map(c => `
          <td class="description">
            ${c.description || "Aucune description"}
          </td>
        `).join("")}
      </tr>

      <tr>
        <th>Hiver</th>
        ${selectedCourses.map(c =>
          `<td>${c.available_terms.winter ? "✔️" : "—"}</td>`
        ).join("")}
      </tr>

      <tr>
        <th>Automne</th>
        ${selectedCourses.map(c =>
          `<td>${c.available_terms.autumn ? "✔️" : "—"}</td>`
        ).join("")}
      </tr>

      <tr>
        <th>Été</th>
        ${selectedCourses.map(c =>
          `<td>${c.available_terms.summer ? "✔️" : "—"}</td>`
        ).join("")}
      </tr>
    </table>
  `;

  result.innerHTML = html;
}

// ==========================
// ENSEMBLE DE COURS
// ==========================
function addToSet() {
  const code = setSelect.value;
  if (courseSet.length >= 6) return;
  if (courseSet.includes(code)) return;

  courseSet.push(code);
  renderSet();
}

function renderSet() {
  const ul = document.getElementById("courseSet");
  ul.innerHTML = "";

  courseSet.forEach(code => {
    const li = document.createElement("li");
    li.textContent = code;
    ul.appendChild(li);
  });
}

// ==========================
// CONFLITS D'HORAIRE
// ==========================
function checkConflicts() {
  const div = document.getElementById("conflicts");
  div.innerHTML =
    "<p>Aucune donnée d’horaire disponible (schedules vides).</p>";
}

// ==========================
// EVENTS
// ==========================
searchInput.addEventListener("input", renderCourses);
termFilter.addEventListener("change", renderCourses);

// ==========================
// START
// ==========================
loadCourses();