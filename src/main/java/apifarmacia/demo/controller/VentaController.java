package apifarmacia.demo.controller;


import apifarmacia.demo.entity.Venta;
import apifarmacia.demo.service.MedicamentoService;
import apifarmacia.demo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    private VentaService ventaService;
    private MedicamentoService medicamentoService;

    @Autowired
    public VentaController(VentaService ventaService, MedicamentoService medicamentoService) {
        this.ventaService = ventaService;
        this.medicamentoService = medicamentoService;
    }

    @PostMapping(value = "crear/{idMedicamento}", headers = "Accept=application/json")
    public ResponseEntity<String> crearVenta(@PathVariable Long idMedicamento, @RequestBody Venta venta ){
        try{
            ventaService.createdVenta(venta);
            medicamentoService.restarStock(idMedicamento, venta.getCantidad());
            return ResponseEntity.status(HttpStatus.CREATED).body("ok");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(value = "listar", headers = "Accept=application/json")
    public List<Venta> ListarVentas() {
        return ventaService.listarVenta();
    }

    @GetMapping(value = "listarFecha/{fecha}", headers = "Accept=application/json")
    public List<Venta> ListarVentasByFecha(@PathVariable String fecha) {
        return ventaService.listarVentaByFecha(fecha);
    }
}
