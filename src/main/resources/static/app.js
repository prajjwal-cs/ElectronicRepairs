document.addEventListener("DOMContentLoaded", function () {
    const repairForm = document.getElementById("repairForm");
    const repairList = document.getElementById("repairList");

    // Add event listener to the repair form submit event
    repairForm.addEventListener("submit", function (event) {
        event.preventDefault();
        createRepairRequest();
    });

    // Fetch all repairs and display them on page load
    fetchRepairs();

    // Function to create a new repair request
    function createRepairRequest() {
        const customerName = document.getElementById("customerName").value;
        const device = document.getElementById("device").value;
        const issue = document.getElementById("issue").value;

        const repair = {
            customerName: customerName,
            device: device,
            issue: issue,
            status: "Pending"
        };

        fetch("/api/repairs", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(repair)
        })
            .then(response => response.json())
            .then(data => {
                // Clear form fields after successful submission
                repairForm.reset();
                // Add the new repair to the repair list
                addRepairToList(data);
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }

    // Function to fetch all repairs and display them in the repair list
    function fetchRepairs() {
        fetch("/api/repairs")
            .then(response => response.json())
            .then(data => {
                data.forEach(repair => {
                    addRepairToList(repair);
                });
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }

    // Function to add a repair to the repair list
    function addRepairToList(repair) {
        const repairItem = document.createElement("li");
        repairItem.textContent = `${repair.customerName} - ${repair.device} (${repair.status})`;

        const completeButton = document.createElement("button");
        completeButton.textContent = "Complete";
        completeButton.addEventListener("click", function () {
            markRepairStatus(repair.id, "Complete");
        });

        const incompleteButton = document.createElement("button");
        incompleteButton.textContent = "Incomplete";
        incompleteButton.addEventListener("click", function () {
            markRepairStatus(repair.id, "Incomplete");
        });

        repairItem.appendChild(completeButton);
        repairItem.appendChild(incompleteButton);

        repairList.appendChild(repairItem);
    }

    // Function to mark repair status as complete or incomplete
    function markRepairStatus(repairId, status) {
        const data = {
            status: status
        };

        fetch(`/api/repairs/${repairId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    // Update the status in the frontend
                    const repairItem = document.querySelector(`li[data-id="${repairId}"]`);
                    repairItem.textContent = `${repairItem.textContent.split(" - ")[0]} - ${status}`;
                } else {
                    console.error("Error:", response.status);
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }
});
