function showCourses(){
    fetch("http://localhost:8080/courses", {
                                                 credentials: "include"
                                             })
    .then((response) => response.json())
    .then((courses) => {
        const dataTable = document.getElementById("coursetable")

        courses.forEach(course => {
            var row = `<tr>
            <td>${course.courseid}</td>
            <td>${course.coursename}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
            </tr>`

            dataTable.innerHTML+=row;
        });
    });
}
function showEnrolledStudents(){
    fetch("http://localhost:8080/courses/enrolled", {
        credentials: "include"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Unauthorized");
        }
        return response.json();
    })
    .then((students) => {
        const dataTable = document.getElementById("enrolledtable");

        students.forEach(student => {
            var row = `<tr>
            <td>${student.name}</td>
            <td>${student.emailid}</td>
            <td>${student.courseName}</td>
            </tr>`;

            dataTable.innerHTML += row;
        });
    })
    .catch(err => {
        alert("Access denied. Please login.");
        window.location.href = "login.html";
    });
}