package io.giyhub.prajjwal.electronicrepairs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repairs")
public class RepairController {
    private final RepairService repairService;

    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @PostMapping
    public Repair createRepairRequest(@RequestBody Repair repair) {
        return repairService.createRepairRequest(repair);
    }

    @PutMapping("/{id}/status")
    public Repair updateRepairRequest(@PathVariable("id") Long repairId, @RequestParam String status) {
        return repairService.updateRepairStatus(repairId, status);
    }

    @GetMapping
    public List<Repair> getAllRepairs() {
        return repairService.getAllRepairs();
    }

    @GetMapping("/customer/{customerName}")
    public List<Repair> getRepairsByCustomerName(@PathVariable String customerName) {
        return repairService.getRepairsByCustomerName(customerName);
    }

    @GetMapping("/status/{status}")
    public List<Repair> getRepairsByStatus(@PathVariable String status) {
        return repairService.getRepairsByStatus(status);
    }

    @GetMapping("/device/{device}")
    public List<Repair> getRepairByDevice(@PathVariable String device) {
        return repairService.getRepairsByDevice(device);
    }

    @GetMapping("/customer/{customerName}/device/{device}")
    public List<Repair> getRepairsByCustomerNameAndDevice(
            @PathVariable String customerName, @PathVariable String device) {
        return repairService.getRepairsByCustomerNameAndDevice(customerName, device);
    }

    @GetMapping("/count/status/{status}")
    public Long getCountByStatus(@PathVariable String status) {
        return repairService.getCountByStatus(status);
    }

    @GetMapping("/customer/pendingStatus/{customerName}")
    public List<Repair> getPendingRepairsOrderedByCustomerName(@PathVariable String customerName) {
        return repairService.getPendingRepairsOrderedByCustomerName(customerName);
    }

    @DeleteMapping("/{id}")
    public void deleteRepair(@PathVariable("id") Long repairId) {
        repairService.deleteRepair(repairId);
    }
}
