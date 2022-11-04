package com.usmp.persistencia.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usmp.persistencia.models.entities.Alumno;
import com.usmp.persistencia.models.entities.Apoderado;
import com.usmp.persistencia.models.entities.Control;
import com.usmp.persistencia.models.entities.Detalledi;
import com.usmp.persistencia.models.entities.DetallediPK;
import com.usmp.persistencia.models.entities.Matricula;
import com.usmp.persistencia.models.entities.Nivel;
import com.usmp.persistencia.models.entities.Numero;
import com.usmp.persistencia.models.entities.NumeroPK;
import com.usmp.persistencia.models.entities.Pai;
import com.usmp.persistencia.models.entities.Parentesco;
import com.usmp.persistencia.models.entities.ParentescoPK;
import com.usmp.persistencia.models.entities.REPORTE_MATRICULADOS;
import com.usmp.persistencia.models.entities.Religion;
import com.usmp.persistencia.models.entities.Tipodisca;
import com.usmp.persistencia.models.entities.Tipotele;
import com.usmp.persistencia.models.service.IAlumnoService;
import com.usmp.persistencia.models.service.IApoderadoService;
import com.usmp.persistencia.models.service.IControlService;
import com.usmp.persistencia.models.service.IDetalledisService;
import com.usmp.persistencia.models.service.IMatriculaService;
import com.usmp.persistencia.models.service.INivelService;
import com.usmp.persistencia.models.service.INumeroService;
import com.usmp.persistencia.models.service.IPaisService;
import com.usmp.persistencia.models.service.IParentescoService;
import com.usmp.persistencia.models.service.IReligionService;
import com.usmp.persistencia.models.service.IReporteMatriculadosService;
import com.usmp.persistencia.models.service.IReporteVacantesService;
import com.usmp.persistencia.models.service.ITipodiscaService;
import com.usmp.persistencia.models.service.ITipoteleService;

@Controller
@SessionAttributes("nido")
public class NidoController {
	
	//hacemos la instancia a todos los Iservices
	@Autowired
	private IAlumnoService alumnoService;
	
	@Autowired
	private IApoderadoService apoderadoService;
	
	@Autowired
	private IControlService controlService;
	
	@Autowired
	private IMatriculaService matriculaService;
	
	@Autowired
	private INivelService nivelService;
	
	@Autowired
	private INumeroService numeroService; 
	
	@Autowired
	private ITipodiscaService tipodiscaService;
	
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private IParentescoService parentescoService;
	
	@Autowired 
	private IReligionService religionService;
	
	@Autowired
	private IDetalledisService  detalleDisService;
	
	@Autowired
	private ITipoteleService tipoTeleService;
	
	@Autowired
	private IReporteMatriculadosService reporteMatriculadoService;
	
	@Autowired
	private IReporteVacantesService reporteVacantesService;

	//----fin de las instancias---//
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) //listamos los alumnos
	public String index (Model model) {
		
		return "index";
			
	}	
	
	
	@RequestMapping(value = "/iniciosession", method = RequestMethod.GET) //listamos los alumnos
	public String inicioSession (Model model) {
		
		return "iniciosession";
			
	}	
		
	//----ALUMNO---//
	@RequestMapping(value = "/listarAlumno", method = RequestMethod.GET) //listamos los alumnos
	public String listarAlumno (Model model) {
		model.addAttribute("alu", alumnoService.findAll());
		return "listarAlumno";
			
	}	
		
	@RequestMapping(value = "/registroAlumno") //pintamos el registroAlumno.html
	public String crearAlumno(Map<String, Object> model) {
		System.out.println("crearAlumno - INI");

		List<Pai> listapais = paisService.findAll();	//para llenar el combobox de Pais
		List<Religion> listareligion = religionService.findAll(); //para llenar el combobox de Religion
				
		Alumno alumno = new Alumno();
		model.put("alumno", alumno); //se llena con los datos que el usuario registra
		model.put("titulo", "Registrar Alumno");		
		model.put("pais", listapais);		
		model.put("religion", listareligion);
	
		System.out.println("crearAlumno - FIN");
		return "registroAlumno";
	}
	
	@RequestMapping(value = "/registroAlumno", method = RequestMethod.POST) //registro de un alumno
	public String registrarAlumno(@Validated Alumno alumno, BindingResult result, 
			Model model, SessionStatus status ) {
		
		if(result.hasErrors()) {

			List<Pai> listapais = paisService.findAll();	//para llenar el combobox de Pais
			List<Religion> listareligion = religionService.findAll(); //para llenar el combobox de Religion
			
			
			model.addAttribute("titulo", "Verifique los datos ingresados");
			model.addAttribute("alumno", alumno); //para que en la pestaña tenga el alumno
			model.addAttribute("pais", listapais);
			model.addAttribute("religion", listareligion);
			
			status.setComplete();
			System.out.println("registrarAlumno - un error...validar en pantalla");
			System.out.println("registrarAlumno - errores :" + result.getAllErrors() );
			return "registroAlumno";
			
		}
		System.out.println("registrarAlumno - INI");
		try {
			String fec = alumno.getFecnacTxt();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cFec = Calendar.getInstance();
			cFec.setTime( dateFormat.parse(fec));
			
			alumno.setFecnac( new Timestamp( cFec.getTimeInMillis() ) );
				
		} catch (Exception e) {
			System.out.println( "Error = " + e.getMessage() );
		}
		System.out.println("registrarAlumno - por validar errores");
		 
			alumnoService.save(alumno);
			status.setComplete();
			
			System.out.println("registrarAlumno - registro correcto...listar");
			//return "redirect:listarAlumno"; //cuando registro me manda a listar defrente
			//cuando registre, esto me mandara a registrar a su apoderado
			
			return "redirect:registroApoderado";
		 
	}

	
	
	 @RequestMapping(value="/registroAlumno/{id}")
	public String editarAlumno(@PathVariable(value="id") String id, Map<String, 
			                                                    Object> model) {	
		 
		List<Pai> listapais = paisService.findAll();	//para llenar el combobox de Pais
		List<Religion> listareligion = religionService.findAll(); //para llenar el combobox de Religion
			 
		Alumno alumno = null;
	
		if(id != null) {
			alumno = alumnoService.findOne(id);
			
								
		} else {
			return "redirect:/listarAlumno";
		}
		
		try {
		
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
			alumno.setFecnacTxt( dateFormat.format( alumno.getFecnac() ));
			
		} catch (Exception e) {
			System.out.println( "Error = " + e.getMessage() );
		}
		
		model.put("alumno", alumno);
		
		model.put("pais", listapais);		
		model.put("religion", listareligion);
		
		model.put("titulo", "Editar Alumno");
		return "registroAlumno";
	}
	
	 	  
	  @RequestMapping(value="/eliminarAlumno/{id}")
	public String eliminarAlumno(@PathVariable(value="id") String id) {
		
		if(id != null) {
			alumnoService.delete(id);
		}
		return "redirect:/listarAlumno";
	}

	  
	  	
	
	//----APONDERADO---//
	
	@RequestMapping(value = "/listarApoderado", method = RequestMethod.GET) //listamos los alumnos
	public String listarApoderado (Model model) {
			model.addAttribute("apon", apoderadoService.findAll());
			return "listarApoderado";
				
	}
	  
	  
	@RequestMapping(value = "/registroApoderado") //pintamos el registroApoderado.html
	public String crearApoderado(Map<String, Object> model) {
				
			
		List<Religion> listareligion = religionService.findAll(); //para llenar el combobox de Religion
						
		Apoderado apoderado = new Apoderado();
		model.put("apoderado", apoderado); //se llena con los datos que el usuario registra
		model.put("titulo", "Registrar Apoderado");		

		model.put("religion", listareligion);
		
		return "registroApoderado";
	}
	
	

	@RequestMapping(value = "/registroApoderado", method = RequestMethod.POST) //registro de un aponderado
	public String registrarApoderado(@Validated Apoderado apoderado, 
							BindingResult result, Model model, SessionStatus status) {
		System.out.println("registrarApoderado - INI" );
		
		if(result.hasErrors()) {
			System.out.println("registrarApoderado - hay errores " );
			
			List<Pai> listapais = paisService.findAll();	//para llenar el combobox de Pais
			List<Religion> listareligion = religionService.findAll(); //para llenar el combobox de Religion
		
			model.addAttribute("titulo", "Verifique los datos ingresados");
			model.addAttribute("apoderado", apoderado); //para que en la pestaña tenga el alumno
			model.addAttribute("pais", listapais);
			model.addAttribute("religion", listareligion);
			
			System.out.println("registrarApoderado - errores :" + result.getAllErrors() );
			
			return "registroApoderado";

		}
		
		System.out.println("registrarApoderado -inicia el registro" );

			try {
				String fec = apoderado.getFecnacTxt();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cFec = Calendar.getInstance();
				cFec.setTime( dateFormat.parse(fec));
				
				apoderado.setFecnacapon( new Timestamp( cFec.getTimeInMillis() ) );
					
			} catch (Exception e) {
				System.out.println( "Error = " + e.getMessage() );
			}
			
			
			apoderadoService.save(apoderado);
			status.setComplete();
			
			System.out.println("registrarApoderado - FIN" );	
			return "redirect:listarApoderado"; //dsp del registrar al apoderado, me aparecera la lista de alumno
		
	}

	@RequestMapping(value="/eliminarApoderado/{id}")
	public String eliminarApoderado(@PathVariable(value="id") String id) {
		
		if(id != null) {
			apoderadoService.delete(id);
		}
		return "redirect:/listarApoderado";
	}
	
	@RequestMapping(value="/registroApoderado/{id}")
	public String editarApoderado(@PathVariable(value="id") String id, Map<String, 
			                                                    Object> model) {	
		 
		List<Pai> listapais = paisService.findAll();	//para llenar el combobox de Pais
		List<Religion> listareligion = religionService.findAll(); //para llenar el combobox de Religion
			 
		Apoderado apoderado = null;
		

		if(id != null) {
			apoderado = apoderadoService.findOne(id);
			
								
		} else {
			return "redirect:/listarApoderado";
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		apoderado.setFecnacTxt( dateFormat.format( apoderado.getFecnacapon() ));
		
		model.put("apoderado", apoderado);
		
		model.put("pais", listapais);		
		model.put("religion", listareligion);
		
		model.put("titulo", "Editar Apoderado");
		return "registroApoderado";
	}
	

	
	//numeroTelefono


	 @RequestMapping(value = "/listarNumero", method = RequestMethod.GET) 
		public String listarNumero (Model model) {
		// System.out.println( "dni apoderado " + Numero.this.getApoderado().getDniapon());
			model.addAttribute("numeros", numeroService.findAll());
			return "listarNumero";
				
		}
	 
	 @RequestMapping(value = "/agregarNumero") //pintamos el agregarNumero.html
		public String crearNumero(Map<String, Object> model) {
			System.out.println("crearNumero - INI");
			
		List<Apoderado> listarApoderado = apoderadoService.findAll();
			 List<Tipotele> listarTipotele = tipoTeleService.findAll();
		
			Numero numero=new Numero();
			model.put("numero", numero); //se llena con los datos del numero
			model.put("titulo", "Agregar Numero");		
			model.put("apoderados", listarApoderado);
			model.put("tipotele", listarTipotele);
			
			System.out.println("crearTelefono - FIN");
			return "agregarNumero"; 
		}
	 
	 @RequestMapping(value = "/agregarNumero", method = RequestMethod.POST) //registro de un numero
		public String registrarNumero(@Validated Numero numero, BindingResult result, Model model, SessionStatus status) {
		 System.out.println("agregarNumero - INI");
		 
		 boolean otrosErrores = false;
			if (numero.getApoderado().getDniapon().equals("0") || 
					numero.getTipotele().getIdtele() == 0L) {
				System.out.println("registrarControl - DEBES SELECCIONAR UN apoderado");
				//RETURN par que no ejeciute el insert ´
				otrosErrores = true;
			}			
		
			if(result.hasErrors() || otrosErrores ) {
				
				List<Apoderado> listarApoderado = apoderadoService.findAll();// para el combo box con dni apoderado
				 List<Tipotele> listarTipotele = tipoTeleService.findAll();// para el combo box con tipo de telefono
											
				model.addAttribute("titulo", "Verifique los datos ingresados");
				model.addAttribute("numero", numero); 
				model.addAttribute("apoderados", listarApoderado); // para llenar la pestaña con dni aponderado
				model.addAttribute("tipotele", listarTipotele);// para llenar la pestaña con tipo de telefono
				
				System.out.println("agregarNumero- un error...validar en pantalla");
				return "agregarNumero";
				
			}else {
				
				
				System.out.println("agregarNumero - apoderado = " + numero.getApoderado().getDniapon() );
				System.out.println("agregarNumero - tipotele = " + numero.getTipotele().getIdtele() );		
				NumeroPK pk= new NumeroPK();
				pk.setApoderadoDniapon(numero.getApoderado().getDniapon());
				pk.setTipoteleIdtele(numero.getTipotele().getIdtele());
				numero.setId( pk );
				numeroService.save(numero);
				status.setComplete();
				
				System.out.println("agregarNumero - registro correcto...listar");
				return "redirect:listarNumero";
			}
		}


	//RELIGION
	//mostramos en la lista las RELIGIONES
	@RequestMapping(value = "/listarReligion", method = RequestMethod.GET) 
	public String listarReligion (Model model) {
		List<Religion> listareligion = religionService.findAll();
		model.addAttribute("reli", listareligion);
		return "listarReligion";
			
	}	
	@RequestMapping(value = "/agregarReligion") //pintamos el agregarReligion.html
	public String crearReligion(Map<String, Object> model) {
		System.out.println("agregarReligion - INI");

		
		Religion reli = new Religion();
		model.put("reli", reli); //se llena con los datos que el usuario registra
		model.put("titulo", "Agregar Religion");		
			
		System.out.println("agregarReligion - FIN");
		return "agregarReligion";
	}
	
	@RequestMapping(value = "/agregarReligion", method = RequestMethod.POST) //registro de un alumno
	public String registrarReligion(@Validated Religion reli, BindingResult result, Model model, SessionStatus status) {
		
		List<Religion> listareligion = religionService.findAll(); //para llenar el combobox de Religion
		
		System.out.println("agregarReligion - INI");
				
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Verifique los datos ingresados");
			model.addAttribute("reli", reli); //para que en la pestaña tenga la religion
			model.addAttribute("reli", listareligion);
			
			
			System.out.println("agregarReligion - un error...validar en pantalla");
			return "agregarReligion";
			
		}else {
			religionService.save(reli);
			status.setComplete();
			
			System.out.println("agregarReligion - registro correcto...listar");
			return "redirect:listarReligion";
		}
	}

	
	 @RequestMapping(value="/eliminarReligion/{id}")
		public String eliminarReligion(@PathVariable(value="id") Long id) {
			
			if(id > 0) {
				religionService.delete(id);
			}
			return "redirect:/listarReligion";
		}

	 @RequestMapping(value="/agregarReligion/{id}")
		public String editarReligion(@PathVariable(value="id") Long id, Map<String, 
				                                                    Object> model) {		
			Religion reli = null;
			
			if(id > 0) {
				reli = religionService.findOne(id);
			} else {
				return "redirect:/listarReligion";
			}
			model.put("reli", reli);
			model.put("titulo", "Editar Religion");
			return "agregarReligion";
		}
	
	 //PARENTESCO
	 
	 @RequestMapping(value = "/listarParentesco", method = RequestMethod.GET) 
		public String listarParentesco (Model model) {
			//List<Parentesco> listarParentesco = parentescoService.findAll();
			model.addAttribute("parentesco", parentescoService.findAll());
			return "listarParentesco";
				
		}
	 
	 @RequestMapping(value = "/agregarParentesco") //pintamos el agregarParentesco.html
		public String crearParentesco(Map<String, Object> model) {
			System.out.println("crearParentesco - INI");
			
		List<Apoderado> listarApoderado = apoderadoService.findAll();
			 List<Alumno> listarAlumno = alumnoService.findAll();
			 
			Parentesco parentesco = new Parentesco();
			
			model.put("parentesco", parentesco); //se llena con los datos del parentesco
			model.put("titulo", "Agregar Parentesco");		
			model.put("apoderados", listarApoderado);
			model.put("alumnos", listarAlumno);
			
			System.out.println("crearParentesco - FIN");
			return "agregarParentesco"; 
		}
	 
	 @RequestMapping(value = "/agregarParentesco", method = RequestMethod.POST) //registro de un alumno
		public String registrarParentesco(@Validated Parentesco parentesco, BindingResult result, Model model, SessionStatus status) {
		 System.out.println("agregarParentesco - INI");
		 
		 List<Apoderado> listarApoderado = apoderadoService.findAll();// para el combo box con dni aponderado
		 List<Alumno> listarAlumno = alumnoService.findAll();// para el combo box con dni alumno
					
			if(result.hasErrors()) {
				
				model.addAttribute("titulo", "Verifique los datos ingresados");
				model.addAttribute("parentesco", parentesco); 
				model.addAttribute("apoderado", listarApoderado); // para llenar la pestaña con dni aponderado
				model.addAttribute("alumno", listarAlumno);// para llenar la pestaña con dni alumno
				
				System.out.println("agregarParentesco - un error...validar en pantalla");
				System.out.println("registrarPARENTESCO - errores :" + result.getAllErrors() );
				return "agregarParentesco";
				
			}else {
				
				System.out.println("agregarParentesco - alumno = " + parentesco.getAlumno().getDnialu() );
				System.out.println("agregarParentesco - apoderado = " + parentesco.getApoderado().getDniapon() );
							
				ParentescoPK pk = new ParentescoPK();
				pk.setAlumnoDnialu(parentesco.getAlumno().getDnialu());
				pk.setApoderadoDniapon(parentesco.getApoderado().getDniapon());
				parentesco.setId( pk );
				parentescoService.save(parentesco);
				status.setComplete();
				
				System.out.println("agregarParentesco - registro correcto...listar");
				return "redirect:listarParentesco";
			}
		}

	 //MATRICULA
	 
	 @RequestMapping(value = "/listarMatricula", method = RequestMethod.GET) 
		public String listarMatricula (Model model) {
			//List<Parentesco> listarParentesco = parentescoService.findAll();
			model.addAttribute("matricula", matriculaService.findAll());
			return "listarMatricula";
				
		}
	 
	 @RequestMapping(value = "/agregarMatricula") //pintamos el agregarParentesco.html
		public String crearMatricula(Map<String, Object> model) {
			System.out.println("crearMatricula - INI");
			
			List<Alumno> listarAlumno = alumnoService.findAll();
			List<Nivel> listarNivel = nivelService.findAll();
			
			Matricula matricula = new Matricula();
			
			model.put("matricula", matricula); 
			model.put("titulo", "Agregar Matricula");		
			model.put("nivels", listarNivel);
			model.put("alumnos", listarAlumno);
			
			System.out.println("crearMatricula - FIN");
			return "agregarMatricula"; 
		}
	 
	 @RequestMapping(value = "/agregarMatricula", method = RequestMethod.POST) //registro de un alumno
		public String registrarMatricula(@Validated Matricula matricula, BindingResult result, Model model, SessionStatus status) {
			
		 boolean otrosErrores = false;
			if (matricula.getAlumno().getDnialu().equals("0") || 
					matricula.getNivel().getIdnivel() == 0L) {
				System.out.println("registrarControl - DEBES SELECCIONAR UN apoderado");
				//RETURN par que no ejeciute el insert ´
				otrosErrores = true;
			}	
			
			System.out.println("agregarParentesco - INI");
			
				
			if(result.hasErrors() || otrosErrores) {
				List<Alumno> listarAlumno = alumnoService.findAll(); //para el combo box del dni
				List<Nivel> listarNivel = nivelService.findAll(); //para el combo box del nivel
				
				model.addAttribute("titulo", "Verifique los datos ingresados");
				model.addAttribute("matricula", matricula); 
				model.addAttribute("nivels", listarNivel); // para llenar la pestaña con dni aponderado
				model.addAttribute("alumnos", listarAlumno);// para llenar la pestaña con dni alumno
				
				System.out.println("agregarParentesco - un error...validar en pantalla");
				return "agregarMatricula";
				
			}else {
				
				try { //FECHA DEL MATRICULA
					String fec = matricula.getFecnacTxt();
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Calendar cFec = Calendar.getInstance();
					cFec.setTime( dateFormat.parse(fec));
					
					matricula.setFecmatri( new Timestamp( cFec.getTimeInMillis() ) );
						
				} catch (Exception e) {
					System.out.println( "Error = " + e.getMessage() );
				}
					
				
				matriculaService.save(matricula);
				status.setComplete();
				
				System.out.println("agregarParentesco - registro correcto...listar");
				return "redirect:listarMatricula";
			}
		}
	 
	 @RequestMapping(value="/agregarMatricula/{id}")
		public String editarMatricula(@PathVariable(value="id") Long id, Map<String, Object> model) {	
			 
			List<Alumno> listaAlumnos = alumnoService.findAll();	//para llenar el combobox de Alumno
			List<Nivel> listarNivel = nivelService.findAll(); 
				 
			Matricula matricula= null;
		
			if(id > 0) {
				matricula = matriculaService.findOne(id);
				
									
			} else {
				return "redirect:/listarControl";
			}
			
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
			matricula.setFecnacTxt( dateFormat.format( matricula.getFecmatri() ));
				
			
			
			model.put("matricula", matricula);
			model.put("nivels", listarNivel);
			model.put("alumnos", listaAlumnos);		
			
			model.put("titulo", "Editar Matricula");
			return "agregarMatricula";
		}
	 
	  @RequestMapping(value="/eliminarMatricula/{id}")
			public String eliminarMatricula(@PathVariable(value="id") Long id) {
				
				if(id > 0) {
					matriculaService.delete(id);
				}
				return "redirect:/listarMatricula";
			}
	 
	 //CONTROL ALUMNO
	 
	 @RequestMapping(value = "/listarControl", method = RequestMethod.GET) //listamos los alumnos
		public String listarControl (Model model) {
			model.addAttribute("con", controlService.findAll());
			return "listarControl";
				
		}	
			
		@RequestMapping(value = "/registroControl") //pintamos el registroControl.html
		public String crearControl(Map<String, Object> model) {
			System.out.println("crearControl - INI");

			List<Alumno> listaAlumnos = alumnoService.findAll();	//para llenar el combobox de Alumno
			
					
			Control con = new Control();
			model.put("control", con); //se llena con los datos que el usuario registra
			model.put("titulo", "Registrar Control");		
			model.put("alumno", listaAlumnos);		
		
			System.out.println("crearControl - FIN");
			return "registroControl";
		}
		
		@RequestMapping(value = "/registroControl", method = RequestMethod.POST) //registro de un control
		public String registroControl(@Validated Control control, BindingResult result, Model model, SessionStatus status) {
			System.out.println("registrarControl - INI");
			
			boolean otrosErrores = false;
			if ( control.getAlumno().getDnialu().equals("0") ) {
				System.out.println("registrarControl - DEBES SELECCIONAR UN ALUMNO");
				//RETURN par que no ejeciute el insert ´
				otrosErrores = true;
			}
			
			if(result.hasErrors() || otrosErrores) {

				List<Alumno> listaAlumnos = alumnoService.findAll();	//para llenar el combobox de Alumno
				
				model.addAttribute("titulo", "Verifique los datos ingresados");
				model.addAttribute("control", control); //para que en la pestaña tenga el alumno
				model.addAttribute("alumno", listaAlumnos);
				
				System.out.println("registrarControl - un error...validar en pantalla");
				System.out.println("registrarCONTROL - errores :" + result.getAllErrors() );
				return "registroControl";
				
			} 
			
			
			System.out.println("registrarControl - DNI ALUMNO = " +control.getAlumno().getDnialu());
				
				try { //FECHA DEL CONTROL
				String fec = control.getFecnacTxt();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cFec = Calendar.getInstance();
				cFec.setTime( dateFormat.parse(fec));
				
				control.setFecha( new Timestamp( cFec.getTimeInMillis() ) );
					
			} catch (Exception e) {
				System.out.println( "Error = " + e.getMessage() );
			}
			System.out.println("registrarControl - por grabar datos");
			
			controlService.save(control);
			status.setComplete();
			
			System.out.println("registrarControl - registro correcto...listar");
			
			return "redirect:listarControl";
		 
		}

		
		 @RequestMapping(value="/registroControl/{id}")
		public String editarControl(@PathVariable(value="id") Long id, Map<String, Object> model) {	
			 
			List<Alumno> listaAlumnos = alumnoService.findAll();	//para llenar el combobox de Alumno

				 
			Control control = null;
		
			if(id > 0) {
				control = controlService.findOne(id);
				
									
			} else {
				return "redirect:/listarControl";
			}
			
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
			control.setFecnacTxt( dateFormat.format( control.getFecha() ));
				
			
			
			model.put("control", control);
			
			model.put("alumno", listaAlumnos);		
			
			model.put("titulo", "Editar Control");
			return "registroControl";
		}
		
		 	  
		  @RequestMapping(value="/eliminarControl/{id}")
		public String eliminarControl(@PathVariable(value="id") Long id) {
			
			if(id > 0) {
				controlService.delete(id);
			}
			return "redirect:/listarControl";
		}
	 
	//DISCAPACIDAD 
		  
		//DETALLE DISCAP
		@RequestMapping(value = "/listarDetalledis", method = RequestMethod.GET) 
			public String listarDetalledis (Model model) {
				model.addAttribute("detalledi", detalleDisService.findAll());//AQUII
				return "listarDetalledis";
						
			}
			 
		@RequestMapping(value = "/agregarDetalledis") //
			public String crearDetalledis(Map<String, Object> model) {
			System.out.println("creardetalledis - INI");
					
				   
				List<Alumno> listarAlumno = alumnoService.findAll();
				List<Tipodisca> listarTipodisca = tipodiscaService.findAll();
					 Detalledi detalledi=new Detalledi();
					model.put("detalledi", detalledi); //
					model.put("titulo", "Agregar detalledis");
					model.put("tipodisca", listarTipodisca);
					model.put("alumno", listarAlumno);
					System.out.println("crearDetalledis - FIN");
					return "agregarDetalledis"; 
				}
			 
			 @RequestMapping(value = "/agregarDetalledis", method = RequestMethod.POST) //registro de detalle disc
				public String registrarDetalledis(@Validated Detalledi detalledi, BindingResult result, Model model, SessionStatus status) {
				 System.out.println("agregardisca - INI");
				 
				 
				 
					if(result.hasErrors()) {
						List<Tipodisca> listarTipodisca = tipodiscaService.findAll();
						List<Alumno> listarAlumno = alumnoService.findAll();	
						
						model.addAttribute("titulo", "Verifique los datos ingresados");
						model.addAttribute("detalledi", detalledi); 
						model.addAttribute("tipodisca", listarTipodisca);// para llenar la pestaña con tipo de disca
						model.addAttribute("alumno", listarAlumno); // para llenar la pestaña con dni alumno
						
						System.out.println("agregarDetalledisca- un error...validar en pantalla");
						return "agregarTipodisca";
						
					}else {
						
						System.out.println("agregarDetalledi - tipodisca = " + detalledi.getTipodisca().getIdtipodis() );
						System.out.println("agregarDetalledi - alumno = " + detalledi.getAlumno().getDnialu() );		
						DetallediPK pk= new DetallediPK();
						pk.setTipodiscaIdtipodis(detalledi.getTipodisca().getIdtipodis());
						pk.setAlumnoDnialu(detalledi.getAlumno().getDnialu());
						detalledi.setId( pk );
						detalleDisService.save(detalledi);

						status.setComplete();
						
						System.out.println("agregarDetalledis - registro correcto...listar");
						return "redirect:listarDetalledis";
					}	  
			 }
/*	 
	//mostramos en la lista las Tipo disca
	@RequestMapping(value = "/listarTipodisca", method = RequestMethod.GET) 
	public String listarTipodisca (Model model) {
	List<Tipodisca> listatipodisca = tipodiscaService.findAll();
		model.addAttribute("tipodisca", listatipodisca);
		return "listarTipodisca";
					
	}	
	  
	@RequestMapping(value = "/agregarTipodisca") //pintamos el agregarTipodisca.html
	public String crearTipodisca(Map<String, Object> model) {
		System.out.println("agregarTipodisca- INI");

		
		Tipodisca tipodisca = new Tipodisca();
		model.put("tipodisca", tipodisca); //se llena con los datos que el usuario registra
		model.put("titulo", "Agregar Tipodisca");		
			
		System.out.println("agregarTipodisca - FIN");
		return "agregarTipodisca";
	}
	
	@RequestMapping(value = "/agregarTipodisca", method = RequestMethod.POST) 
	public String registrarTipodisca(@Validated Tipodisca tipodisca, BindingResult result, Model model, SessionStatus status) {
		
		List<Tipodisca> listatipodisca = tipoDiscaService.findAll(); //para llenar el combobox de Tipo disca
		
		System.out.println("agregartipodisca - INI");
				
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Verifique los datos ingresados");
			model.addAttribute("tipodisca",tipodisca); //para que en la pestaña tenga el tipo disca
			model.addAttribute("tipodisca", listatipodisca);
			
			
			System.out.println("agregarTipodetelefono - un error...validar en pantalla");
			return "agregarTipodisca";
			
		}else {
			tipodiscaService.save(tipodisca);
			status.setComplete();
			
			System.out.println("agregarTipotele - registro correcto...listar");
			return "redirect:listarTipotele";
		}
	}

	
	 @RequestMapping(value="/eliminarTipodisca/{id}")
		public String eliminarTipodisca(@PathVariable(value="id") Long id) {
			
			if(id > 0) {
				tipodiscaService.delete(id);
			}
			return "redirect:/listarTipodisca";
		}

	 @RequestMapping(value="/agregarTipodisca/{id}")
		public String editarTipodisca(@PathVariable(value="id") Long id, Map<String, 
				                                                    Object> model) {		
		 Tipodisca tipodisca = null;
			
			if(id > 0) {
				tipodisca = tipodiscaService.findOne(id);
			} else {
				return "redirect:/listarTipodisca";
			}
			model.put("tipodisca",tipodisca);
			model.put("titulo", "Editar Tipo de discapacidad");
			return "agregarTipodisca";
		}
	
*/	 

	 
// VISTA AL REPORTE DE ALUMNOS MATRICULADOS POR AÑO Y NIVEL
			 
	@RequestMapping(value = "/listarReporteMatriculado", method = RequestMethod.GET) //listamos los alumnos
	public String listarReporte (Model model) {
		
//		model.addAttribute("reportes", reporteMatriculadoService.findAll());
		model.addAttribute("reportes", reporteMatriculadoService.listaParaReporte() );
		return "listarReporteMatriculado";
							
	}
	
	 
	 
	// VISTA AL REPORTE VACANTE
	 
	@RequestMapping(value = "/listarReporteVacantes", method = RequestMethod.GET) //listamos los alumnos
	public String listarReporte1 (Model model) {
		
		model.addAttribute("reportes", reporteVacantesService.listaParaReporte1() ); 
		//ENVIAMOS EL REPORTE A LA VISTA DEL HTML
		return "listarReporteVacantes";
	}					
	
	 
}
