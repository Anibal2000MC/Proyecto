package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CitaService;
import com.example.demo.model.Cita;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;


@Controller
@RequestMapping("/report")
public class ReportesController {

	@Autowired
	private CitaService citaService;
	
	public Long validar;

	@GetMapping("/reporte-citas")
	public String getAllCita(Model model) {

		List<Cita> listCitas = citaService.getAllCitas();

		model.addAttribute("citas", listCitas);

		return "reporte-citas";
	}

	@PostMapping("/reporte-citas")
	public String buscarCitas(@RequestParam("idMedico") Long idMedico, Model model) {
		List<Cita> listCitas = citaService.encontrarCitasPorIdMedico(idMedico);
		model.addAttribute("citas", listCitas);
		if(idMedico != 0) {
			validar = idMedico;
			}
		return "reporte-citas";
	}

	@GetMapping("/reporte-citas-por-medico")
	public void report(HttpServletResponse response, Model model)
			throws JRException, IOException {
		// 1. Acceder al reporte
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/Simple_Blue.jasper");

		// 2. Preparadar los datos
		Map<String, Object> params = new HashMap<>();
		params.put("usuario", "Anibal Machado");

		List<Cita> listCitas;
		if (validar != 0 ) {
			listCitas = citaService.encontrarCitasPorIdMedico(validar);
			validar = (long) 0;
		}else {
			listCitas = citaService.getAllCitas();
		}
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listCitas);

		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

		// 3. Configuracion

		response.setContentType("aplication/x-pdf");
		response.setHeader("Content-disposition", "filename=reporte_ejemplo.pdf");

		// 4. Exportar reporte
		final OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}

}
