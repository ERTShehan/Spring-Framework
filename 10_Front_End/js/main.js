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
            console.log(error);
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

let allJobs = [];
let currentPage = 1;
const pageSize = 5;


function loadAllJobs() {
    $.ajax({
        url: "http://localhost:8080/api/v1/job/getalljobs",
        type: "GET",
        success: function(jobs) {
            allJobs = jobs.data;
            currentPage = 1;
            renderPaginatedJobs();
            renderPaginationButtons();
        },
        error: function(xhr, status, error) {
            console.log("Error loading jobs:", error);
        }
    });
}

function loadSearchJobs(seachInput){
    $.ajax({
        url: `http://localhost:8080/api/v1/job/search/${seachInput}`,
        type: "GET",
        success: function(jobs) {
            $("#jobsTableBody").empty();
            console.log(jobs)
            jobs.data.forEach(job => {
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
    const answer = confirm("Are you sure you want to delete this job?");
    if (!answer) {
        return;
    }
    $.ajax({
        url: `http://localhost:8080/api/v1/job/delete?id=${id}`,
        type: "PUT",
        success: function(response) {
            alert(response.message);
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
            $("#editJobId").val(job.data.id);
            $("#editJobTitle").val(job.data.jobTitle);
            $("#editCompanyName").val(job.data.company);
            $("#editJobLocation").val(job.data.location);
            $("#editJobType").val(job.data.type);
            $("#editJobDescription").val(job.data.jobDescription);


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
        "status": "Active"
    }


    $.ajax({
        url : `http://localhost:8080/api/v1/job/update`,
        type : "PUT",
        contentType : "application/json",
        data : JSON.stringify(job),
        success : function(job){
            alert(job.message);
            loadAllJobs();
        },
        error : function(xhr, status, error){
            console.log("Error loading job:", error);
        }
    })
}

function deactivateJob(id) {
    $.ajax({
        url: `http://localhost:8080/api/v1/job/changestatus/${id}`,
        type: "PATCH",
        success: function(response) {
            alert(response.message);
            loadAllJobs();
        },
        error: function(xhr, status, error) {
            console.log("Error deactivating job:", error);
        }
    })
}

function renderPaginatedJobs() {
    $("#jobsTableBody").empty();

    const start = (currentPage - 1) * pageSize;
    const end = start + pageSize;
    const jobsToRender = allJobs.slice(start, end);

    jobsToRender.forEach(job => {
        $("#jobsTableBody").append(`
            <tr>
                <td>${job.id}</td>
                <td>${job.jobTitle}</td>
                <td>${job.company}</td>
                <td>${job.location}</td>
                <td>${job.type}</td>
                <td>${job.jobDescription}</td>
                <td>${job.status}</td>
                <td>
                    <button onclick="deleteJob(${job.id})" class="btn btn-danger">Delete</button>
                    <button onclick="loadJobForEdit(${job.id})" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#editJobModal">Edit</button>
                    <button onclick="deactivateJob(${job.id})" class="btn btn-success">Deactivate</button>
                </td>
            </tr>
        `);
    });
}

function renderPaginationButtons() {
    const totalPages = Math.ceil(allJobs.length / pageSize);
    const paginationContainer = $("#pagination");
    paginationContainer.empty();

    for (let i = 1; i <= totalPages; i++) {
        paginationContainer.append(`
            <button class="btn btn-outline-primary m-1" onclick="goToPage(${i})">${i}</button>
        `);
    }
}

function goToPage(page) {
    currentPage = page;
    renderPaginatedJobs();
}