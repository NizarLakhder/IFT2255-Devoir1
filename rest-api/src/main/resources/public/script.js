// ==========================
// ÉTAT GLOBAL
// ==========================
let courses = [];
const courseSet = [];

// ==========================
// CHARGEMENT DES COURS
// ==========================
async function loadCourses() {
  try {
    const response = await fetch("/courses");
    courses = await response.json();

    console.log("Courses chargés :", courses);

    renderCourses();
    populateSelects();
  } catch (err) {
    console.error("Erreur lors du chargement des cours :", err);
  }
}

// ==========================
// AFFICHAGE DES COURS
// ==========================
function renderCourses() {
  const container = document.getElementById("courses");
  const searchInput = document.getElementById("searchInput");

  container.innerHTML = "";

  const query = searchInput.value.toLowerCase();

  courses
    .filter(c =>
      c.id.toLowerCase().includes(query) ||
      c.name.toLowerCase().includes(query)
    )
    .forEach(c => {
      const div = document.createElement("div");
      div.className = "course";

      div.innerHTML = `
        <h3>${c.id}</h3>
        <p><strong>${c.name}</strong></p>
        
      `;

      container.appendChild(div);
    });
}

// ==========================
// REMPLIR LES SELECTS
// ==========================
function populateSelects() {
  const ids = ["compare1", "compare2", "setSelect"];

  ids.forEach(id => {
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
// COMPARER DEUX COURS
// ==========================
function compareCourses() {
  const c1Id = document.getElementById("compare1").value;
  const c2Id = document.getElementById("compare2").value;
  const result = document.getElementById("comparison");

  const c1 = courses.find(c => c.id === c1Id);
  const c2 = courses.find(c => c.id === c2Id);

  if (!c1 || !c2) {
    result.textContent = "Sélection invalide";
    return;
  }

  result.innerHTML = `
    <p><strong>${c1.id}</strong> vs <strong>${c2.id}</strong></p>
    <p>Crédits : ${c1.credits} vs ${c2.credits}</p>
  `;
}

// ==========================
// ENSEMBLE DE COURS
// ==========================
function addToSet() {
  const code = document.getElementById("setSelect").value;

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
// ÉVÉNEMENTS
// ==========================
document.getElementById("searchInput")
  .addEventListener("input", renderCourses);

// ==========================
// DÉMARRAGE
// ==========================
loadCourses();