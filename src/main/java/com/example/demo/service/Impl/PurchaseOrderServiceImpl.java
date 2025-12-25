@Override
public PurchaseOrder create(PurchaseOrder po) {

    if (po.getAmount().signum() <= 0)
        throw new BadRequestException("Amount must be positive");

    Supplier s = supplierRepo.findById(po.getSupplier().getId()).orElseThrow();
    SpendCategory c = categoryRepo.findById(po.getCategory().getId()).orElseThrow();

    if (!s.getIsActive() || !c.getActive())
        throw new BadRequestException("Inactive entity");

    return poRepo.save(po);
}
