$(document).ready(function(){


    loadAllJobs();
    resetFields();

    $("#saveJobBtn").on("click", function(){
        saveJob();
        loadAllJobs();
    })
    const searchInput = [];

    $("#searchInput").on("keyup", function(e) {
        console.log(searchInput)
        if (e.key.length === 1) {
            searchInput.push(e.key);
        } else if (e.key === "Backspace") {
            searchInput.pop();
        }


        if (searchInput.length === 0) {
            loadAllJobs();
        }else if (searchInput.length >= 3) {
            console.log(searchInput.length)
            loadSearchJobs($("#searchInput").val());
        }
    });

    $("#updateJobBtn").on("click", function(){
        updateJob();
    })
})



function saveJob(){
    const title = $("#jobTitle").val();
    const companyName = $("#companyName").val();
    const location = $("#jobLocation").val();
    const jobType = $("#jobType").val();
    const description = $("#jobDescription").val();

    if (!title || !companyName || !location || !jobType) {
        return;
    }

    const job = {
        "jobTitle": title,
        "company": companyName,
        "location": location,
        "type": jobType,
        "jobDescription": description,
        "status": "Active"
    }

    $.ajax({
        url: "http://localhost:8080/api/v1/job/create",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(job),
        success: function(response) {
            console.log("Job saved successfully:", response);
            resetFields();
            loadAllJobs();

        },
        error: function(xhr, status, error) {
            console.log("Error saving job:", error);
        }
    });

}

function resetFields(){
    $("#jobTitle").val("");
    $("#companyName").val("");
    $("#jobLocation").val("");
    $("#jobType").val("Full-time");
    $("#jobDescription").val("")
}

function loadAllJobs(){
    $.ajax({
        url: "http://localhost:8080/api/v1/job/getalljobs",
        type: "GET",
        success: function(jobs) {
            console.log("Test")
            console.log(jobs);
            $("#jobsTableBody").empty();
            jobs.forEach(job => {
                $("#jobsTableBody").append(`
            <tr>
                <td>${job.id}</td>
                <td>${job.jobTitle}</td>
                <td>${job.company}</td>
                <td>${job.location}</td>
                <td>${job.type}</td>
                <td>${job.jobDescription}</td>
                <td>${job.status}</td>
                <td><button onclick="deleteJob(${job.id})" class="btn btn-danger">Delete</button>
                    <button onclick="loadJobForEdit(${job.id})" class="btn btn-warning btnEdit"  data-bs-toggle="modal" data-bs-target="#editJobModal">Edit</button>
                    <button onclick="deactivateJob(${job.id})" class="btn btn-success">Deactive</button>
                
                </td>
            </tr>
        `);
            });
        },

        error: function(xhr, status, error) {
            console.log("Error loading jobs:", error);
        }


    });
}

function loadSearchJobs(seachInput){
    console.log("called")
    $.ajax({
        url: `http://localhost:8080/api/v1/job/search/${seachInput}`,
        type: "GET",
        success: function(jobs) {
            $("#jobsTableBody").empty();
            console.log(jobs)
            jobs.forEach(job => {
                $("#jobsTableBody").append(`
            <tr>
                <td>${job.id}</td>
                <td>${job.jobTitle}</td>
                <td>${job.company}</td>
                <td>${job.location}</td>
                <td>${job.type}</td>
                <td>${job.jobDescription}</td>
                <td>${job.status}</td>
                <td><button onclick="deleteJob(${job.id})" class="btn btn-danger">Delete</button>
                    <button onclick="loadJobForEdit(${job.id})" class="btn btn-warning btnEdit"  data-bs-toggle="modal" data-bs-target="#editJobModal">Edit</button>
                    <button class="btn btn-success">Deactive</button>
                
                </td>
            </tr>
        `);
            });
        },

        error: function(xhr, status, error) {
            console.log("Error loading jobs:", error);
        }


    });
}

function deleteJob(id){
    $.ajax({
        url: `http://localhost:8080/api/v1/job/delete?id=${id}`,
        type: "PUT",
        success: function(response) {
            console.log("Job deleted successfully:", response);
            loadAllJobs();
        },
        error: function(xhr, status, error) {
            console.log("Error deleting job:", error);
        }

    });
}

function loadJobForEdit(id){
    $.ajax({
        url : `http://localhost:8080/api/v1/job/getjob/${id}`,
        type : "GET",
        success : function(job){
            console.log(job)
            $("#editJobId").val(job.id);
            $("#editJobTitle").val(job.jobTitle);
            $("#editCompanyName").val(job.company);
            $("#editJobLocation").val(job.location);
            $("#editJobType").val(job.type);
            $("#editJobDescription").val(job.jobDescription);

        },
        error : function(xhr, status, error){
            console.log("Error loading job:", error);
        }
    })

}

function updateJob(){
    const id = $("#editJobId").val();
    const title = $("#editJobTitle").val();
    const companyName = $("#editCompanyName").val();
    const location = $("#editJobLocation").val();
    const jobType = $("#editJobType").val();
    const description = $("#editJobDescription").val();

    if (!title || !companyName || !location || !jobType) {
        return;
    }

    const job = {
        "id": id,
        "jobTitle": title,
        "company": companyName,
        "location": location,
        "type": jobType,
        "jobDescription": description,
    }


    $.ajax({
        url : `http://localhost:8080/api/v1/job/update`,
        type : "PUT",
        contentType : "application/json",
        data : JSON.stringify(job),
        success : function(job){
            console.log(job)
            loadAllJobs();
        },
        error : function(xhr, status, error){
            console.log("Error loading job:", error);
        }
    })
}

function deactivateJob(id) {
    $.ajax({
        url: `http://localhost:8080/api/v1/job/changeStatus/${id}`,
        type: "PATCH",
        success: function(response) {
            console.log("Job deactivated successfully:", response);
            loadAllJobs();
        },
        error: function(xhr, status, error) {
            console.log("Error deactivating job:", error);
        }
    })
}