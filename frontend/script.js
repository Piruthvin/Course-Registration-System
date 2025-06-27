async function showCourses() {
    try {
        const response = await fetch("http://localhost:8080/courses", {
            credentials: "include"
        });

        if (!response.ok) {
            throw new Error("Failed to fetch courses");
        }

        const courses = await response.json();
        const dataTable = document.getElementById("coursetable");

        courses.forEach(course => {
            const row = `
                <tr>
                    <td>${course.courseid}</td>
                    <td>${course.coursename}</td>
                    <td>${course.trainer}</td>
                    <td>${course.durationInWeeks}</td>
                </tr>`;
            dataTable.innerHTML += row;
        });
    } catch (error) {
        console.error("Error fetching courses:", error);
        alert("Unable to load courses. Please try again later.");
    }
}

async function showEnrolledStudents() {
    try {
        const response = await fetch("http://localhost:8080/courses/enrolled", {
            credentials: "include"
        });

        if (!response.ok) {
            throw new Error("Unauthorized");
        }

        const students = await response.json();
        const dataTable = document.getElementById("enrolledtable");

        students.forEach(student => {
            const row = `
                <tr>
                    <td>${student.name}</td>
                    <td>${student.emailid}</td>
                    <td>${student.courseName}</td>
                </tr>`;
            dataTable.innerHTML += row;
        });
    } catch (error) {
        console.error("Error fetching enrolled students:", error);
        alert("Access denied. Please login.");
        window.location.href = "login.html";
    }
}
