// ==========================
// UTILITAIRES
// ==========================
function getParam(name) {
  return new URLSearchParams(window.location.search).get(name);
}

// ==========================
// CHARGEMENT DU COURS
// ==========================
async function loadCourse() {
  const courseId = getParam("id");
  const semester = getParam("semester");

  if (!courseId) {
    document.getElementById("course-details").innerHTML =
      "<p>Identifiant de cours manquant</p>";
    return;
  }

  try {
    let url = `/courses/${courseId}?include_schedule=true`;
    if (semester) {
      url += `&schedule_semester=${semester}`;
    }

    const response = await fetch(url);
    const course = await response.json();

    renderCourse(course);

  } catch (err) {
    console.error(err);
    document.getElementById("course-details").innerHTML =
      "<p>Erreur lors du chargement du cours</p>";
  }
}

// ==========================
// AFFICHAGE DU COURS
// ==========================
function renderCourse(c) {
  const container = document.getElementById("course-details");

  let html = `
    <h2>${c.id} – ${c.name}</h2>
    <p><strong>Crédits :</strong> ${c.credits}</p>
    <p>${c.description}</p>

    <h3>Conditions</h3>
    <p><strong>Prérequis :</strong> ${
      c.prerequisite_courses?.length
        ? c.prerequisite_courses.join(", ")
        : "Aucun"
    }</p>
    <p><strong>Équivalents :</strong> ${
      c.equivalent_courses?.length
        ? c.equivalent_courses.join(", ")
        : "Aucun"
    }</p>
  `;

  // ==========================
  // HORAIRES
  // ==========================
  if (Array.isArray(c.schedules) && c.schedules.length > 0) {
    html += `<h3>Horaires</h3>`;

    c.schedules.forEach(schedule => {
      html += `
        <div class="schedule">
          <h4>Trimestre ${schedule.semester}</h4>
      `;

      schedule.sections.forEach(section => {
        html += `
          <div class="section">
            <h5>Section ${section.name}</h5>
            <p>
              <strong>Enseignant(s) :</strong>
              ${section.teachers.join(", ")}
              <br>
              <strong>Capacité :</strong> ${section.capacity}
            </p>
        `;

        section.volets.forEach(volet => {
          html += `<div class="volet"><strong>${volet.name}</strong>`;

          volet.activities.forEach(act => {
            html += `
              <div class="activity">
                <p>
                  ${act.days.join(", ")}
                  ${act.start_time} – ${act.end_time}<br>
                  ${act.pavillon_name} – Salle ${act.room}<br>
                  ${act.campus} | Mode ${act.mode}
                </p>
              </div>
            `;
          });

          html += `</div>`;
        });

        html += `</div>`;
      });

      html += `</div>`;
    });

  } else {
    html += `<p>Aucun horaire disponible</p>`;
  }

  container.innerHTML = html;
}

// ==========================
// DÉMARRAGE
// ==========================
loadCourse();