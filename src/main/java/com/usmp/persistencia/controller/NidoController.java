package com.usmp.persistencia.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.usmp.persistencia.models.entities.Alumno;
import com.usmp.persistencia.models.entities.entitiesBORRAR.Pai;
import com.usmp.persistencia.models.entities.entitiesBORRAR.Religion;
import com.usmp.persistencia.models.service.IAlumnoService;
import com.usmp.persistencia.models.service.serviceBORRAR.IPaisService;
import com.usmp.persistencia.models.service.serviceBORRAR.IReligionService;


@Controller
@SessionAttributes("nido")
public class NidoController {

	// hacemos la instancia a todos los Iservices
	@Autowired
	private IAlumnoService alumnoService;

	@Autowired
	private IPaisService paisService;

	@Autowired
	private IReligionService religionService;


	// ----fin de las instancias---//

	@RequestMapping(value = "/index", method = RequestMethod.GET) // listamos los alumnos
	public String index(Model model) {

		return "index";

	}

	@RequestMapping(value = "/iniciosession", method = RequestMethod.GET) // listamos los alumnos
	public String inicioSession(Model model) {

		return "iniciosession";

	}

	// ----ALUMNO---//
	@RequestMapping(value = "/listarAlumno", method = RequestMethod.GET) // listamos los alumnos
	public String listarAlumno(Model model) {
		model.addAttribute("alu", alumnoService.findAll());
		return "listarAlumno";

	}

	@RequestMapping(value = "/registroAlumno") // pintamos el registroAlumno.html
	public String crearAlumno(Map<String, Object> model) {
		System.out.println("crearAlumno - INI");

		List<Pai> listapais = paisService.findAll(); // para llenar el combobox de Pais
		List<Religion> listareligion = religionService.findAll(); // para llenar el combobox de Religion

		Alumno alumno = new Alumno();
		model.put("alumno", alumno); // se llena con los datos que el usuario registra
		model.put("titulo", "Registrar Alumno");
		model.put("pais", listapais);
		model.put("religion", listareligion);

		System.out.println("crearAlumno - FIN");
		return "registroAlumno";
	}

	@RequestMapping(value = "/registroAlumno", method = RequestMethod.POST) // registro de un alumno
	public String registrarAlumno(@Validated Alumno alumno, BindingResult result,
			Model model, SessionStatus status) {

		if (result.hasErrors()) {

			List<Pai> listapais = paisService.findAll(); // para llenar el combobox de Pais
			List<Religion> listareligion = religionService.findAll(); // para llenar el combobox de Religion

			model.addAttribute("titulo", "Verifique los datos ingresados");
			model.addAttribute("alumno", alumno); // para que en la pestaña tenga el alumno
			model.addAttribute("pais", listapais);
			model.addAttribute("religion", listareligion);

			status.setComplete();
			System.out.println("registrarAlumno - un error...validar en pantalla");
			System.out.println("registrarAlumno - errores :" + result.getAllErrors());
			return "registroAlumno";

		}
		System.out.println("registrarAlumno - INI");
		try {
			String fec = alumno.getFecnacTxt();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cFec = Calendar.getInstance();
			cFec.setTime(dateFormat.parse(fec));

			alumno.setFecnac(new Timestamp(cFec.getTimeInMillis()));

		} catch (Exception e) {
			System.out.println("Error = " + e.getMessage());
		}
		System.out.println("registrarAlumno - por validar errores");

		alumnoService.save(alumno);
		status.setComplete();

		System.out.println("registrarAlumno - registro correcto...listar");
		// return "redirect:listarAlumno"; //cuando registro me manda a listar defrente
		// cuando registre, esto me mandara a registrar a su apoderado

		return "redirect:listarAlumno";

	}

	@RequestMapping(value = "/registroAlumno/{id}")
	public String editarAlumno(@PathVariable(value = "id") String id, Map<String, Object> model) {

		List<Pai> listapais = paisService.findAll(); // para llenar el combobox de Pais
		List<Religion> listareligion = religionService.findAll(); // para llenar el combobox de Religion

		Alumno alumno = null;

		if (id != null) {
			alumno = alumnoService.findOne(id);

		} else {
			return "redirect:/listarAlumno";
		}

		try {

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			alumno.setFecnacTxt(dateFormat.format(alumno.getFecnac()));

		} catch (Exception e) {
			System.out.println("Error = " + e.getMessage());
		}

		model.put("alumno", alumno);

		model.put("pais", listapais);
		model.put("religion", listareligion);

		model.put("titulo", "Editar Alumno");
		return "registroAlumno";
	}

	@RequestMapping(value = "/eliminarAlumno/{id}")
	public String eliminarAlumno(@PathVariable(value = "id") String id) {

		if (id != null) {
			alumnoService.delete(id);
		}
		return "redirect:/listarAlumno";
	}
}
