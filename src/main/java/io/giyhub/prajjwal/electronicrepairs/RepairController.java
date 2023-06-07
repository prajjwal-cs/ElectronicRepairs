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
}
