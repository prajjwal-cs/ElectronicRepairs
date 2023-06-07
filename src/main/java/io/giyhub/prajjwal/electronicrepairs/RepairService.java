package io.giyhub.prajjwal.electronicrepairs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairService {
    private final RepairRepository repairRepository;

    @Autowired
    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    public Repair createRepairRequest(Repair repair) {
        repair.setStatus("Pending");
        return repairRepository.save(repair);
    }

    public Repair updateRepairStatus(Long repairId, String status) {
        Repair repair = repairRepository.findById(repairId).orElseThrow(() -> new RuntimeException("Repair not found"));
        repair.setStatus(String.valueOf(repair));
        return repairRepository.save(repair);
    }
}
