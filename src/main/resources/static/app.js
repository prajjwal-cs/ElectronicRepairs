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
            issue: issue
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
        repairList.appendChild(repairItem);
    }
});
