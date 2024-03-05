package edu.udelp.POO;

//Interfaces definir metodos que se usaran
//Abstractas tener metodos similares a los hijos


import java.util.Scanner;


import edu.udelp.POO.Carrera;
import edu.udelp.POO.Materia;
import edu.udelp.POO.Estudiante;
import edu.udelp.POO.Persona;
import edu.udelp.POO.Profesor;
import edu.udelp.POO.MateriaAlumno;
import edu.udelp.POO.util.Utileria;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import edu.udelp.POO.ProcesosPersona;
import edu.udelp.POO.ProcesosEscuela;

public class ImpresionesControlEscolar {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		ProcesosPersona procesosPersona = new ProcesosPersona();
		ProcesosEscuela procesosEscuela = new ProcesosEscuela();
		Utileria util=new Utileria();
		List<Carrera> carreras = new ArrayList<>(); // Lista de carreras
		List<Profesor> profesores = new ArrayList<>(); // Lista de profesores
		List<Estudiante> estudiantes = new ArrayList<>(); // Lista de Estudiantes
		List<Materia> materias = new ArrayList<>(); // Lista de materias
		boolean salir = false;
		while (!salir) {
			System.out.println("Menú:");
			System.out.println("1. Dar de alta carreras");
			System.out.println("2. Dar de alta materias");
			System.out.println("3. Dar de alta un profesor");
			System.out.println("4. Dar de alta un alumno");
			System.out.println("5. Asignar materia a un profesor");
			System.out.println("6. Asignar materias a un alumno");
			System.out.println("7. Editar materias a un alumno");
			System.out.println("8. Agregar calificaciones a un alumno");
			System.out.println("9. Ver datos de un alumno");
			System.out.println("10. Obtener el promedio por materia a un alumno");
			System.out.println("11. Obtener el promedio por alumno en un semestre");
			System.out.println("12. Obtener el promedio del semestre del alumnos");
			System.out.println("13. Obtener el promedio por materia");
			System.out.println("14. Obtener el promedio por carrera");
			System.out.println("15. Crear archivos de las listas");
			System.out.println("16. Leer archivos ");
			System.out.println("17. Salir");
			System.out.print("Ingrese su opción: ");
			String opcion = leer.nextLine();
			if (procesosPersona.validarEntero(opcion) == true) {
				switch (opcion) {
				case "1":
					System.out.println("¿Cuantas carreras desea dar de alta?");
					String opcionCarreras = leer.nextLine();
					if (procesosPersona.validarEntero(opcionCarreras) == true) {
						int numeroCarreras = Integer.parseInt(opcionCarreras);
						for (int i = 0; i <= numeroCarreras - 1; i++) {
							System.out.println("Agrega el nombre de la carrera");
							String nombreCarrera = leer.nextLine();
							if (procesosPersona.validarNombre(nombreCarrera) == true) {
								String idCarrera = procesosPersona.generaID();
								carreras.add(new Carrera(nombreCarrera, idCarrera));
								System.out.println("Carrera Creada:   " + "Nombre: " + nombreCarrera + " " + "id: " + idCarrera);
							} else {
								System.out.println("Error, agrega un valor de tipo cadena");
								break;
							}
						}
					} else {
						System.out.println("Error, agrega un valor de tipo entero");
						break;
					}
					break;
				case "2":
					if (!carreras.isEmpty()) {
						System.out.println("Dar de alta materias");
						System.out.println("¿Cuantas materias desea dar de alta?");
						String opcionMaterias = leer.nextLine();
						if (procesosPersona.validarEntero(opcionMaterias) == true) {
							int numeroMaterias = Integer.parseInt(opcionMaterias);
							for (int i = 0; i <= numeroMaterias - 1; i++) {
								System.out.println("Agrega el semestre de la materia");
								String semestreMateriaCadena = leer.nextLine();
								if (procesosPersona.validarEntero(semestreMateriaCadena) == true) {
									Integer semestreMateria = Integer.parseInt(semestreMateriaCadena);
									System.out.println("Agrega el horario de la materia");
									String horarioMateria = leer.nextLine();
									if (procesosPersona.validarNombre(horarioMateria) == true) {
										System.out.println("Agrega el nombre de la materia");
										String nombreMateria = leer.nextLine();
										if (procesosPersona.validarNombre(nombreMateria) == true) {
											System.out.println(
													"¿En qué carrera desea dar de alta materias? Ingrese el ID de la carrera:");
											for (int j = 0; j < carreras.size(); j++) {
												Carrera carrera = carreras.get(j);
												System.out.println(
														"ID: " + carrera.getId() + ", Nombre: " + carrera.getNombre());
											}
											String idCarreraSeleccionada = leer.nextLine();
											Carrera carreraSeleccionada = procesosEscuela.buscarCarreraPorId(carreras,idCarreraSeleccionada);
											if (carreraSeleccionada != null) {
												String idMateria = procesosPersona.generaID();
												materias.add(new Materia(semestreMateria, horarioMateria, nombreMateria,carreraSeleccionada, idMateria));
												System.out.println("Materia creada:");
												System.out.println("Nombre: " + nombreMateria);
												System.out.println("Semestre: " + semestreMateria);
												System.out.println("Horario: " + horarioMateria);
												System.out.println("Carrera: " + carreraSeleccionada.getNombre());
												System.out.println("ID de la materia: " + idMateria);
											} else {
												System.out.println(
														"Error, la carrera con el ID ingresado no existe. Por favor, ingrese un ID válido.");
												break;
											}
										} else {
											System.out.println("Error, agrega un valor de tipo cadena");
											break;
										}
									} else {
										System.out.println("Error, agrega un valor de tipo cadena");
										break;
									}
								} else {
									System.out.println("Error, agrega un valor de tipo cadena");
									break;
								}
							}
						} else {
							System.out.println("Error, agrega un valor de tipo entero");
							break;
						}
					} else {
						System.out.println("Error, no existen carreras, agrega alguna");
						break;
					}
					break;
				case "3":
					System.out.println("Dar de alta un profesor");
					System.out.print("Nombre: ");
					String nombre = leer.nextLine();
					if (procesosPersona.validarNombre(nombre)) {
						System.out.print("Fecha de nacimiento (formato dd/mm/yyyy): ");
						String fechaNacimientoString = leer.nextLine(); 
						if (procesosPersona.validarFecha(fechaNacimientoString)) {
							String[] partesFecha = fechaNacimientoString.split("/");
							Calendar fechaNacimiento = Calendar.getInstance();
							fechaNacimiento.set(Integer.parseInt(partesFecha[2]), Integer.parseInt(partesFecha[1]) - 1,Integer.parseInt(partesFecha[0]));
							System.out.print("Sexo (H/M): ");
							char sexo = leer.nextLine().toUpperCase().charAt(0);
							if (procesosPersona.validarSexo(sexo)) {
								System.out.print("Fecha de Ingreso (formato dd/mm/yyyy): ");
								String fechaIngresoString = leer.nextLine(); 
								if (procesosPersona.validarFecha(fechaIngresoString)) {
									String[] partesFechaIngreso = fechaIngresoString.split("/");
									Calendar fechaIngreso = Calendar.getInstance();
									fechaIngreso.set(Integer.parseInt(partesFechaIngreso[2]),Integer.parseInt(partesFechaIngreso[1]) - 1,Integer.parseInt(partesFechaIngreso[0]));
									String id = procesosPersona.generaID();
									System.out.println("ID Generado: " + id);
									Profesor nuevoProfesor = new Profesor(nombre, fechaNacimiento, id, sexo,fechaIngreso);
									profesores.add(nuevoProfesor);
									System.out.println("Profesor creado exitosamente.");
									SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
									String fechaNacimientoFormato = formatoFecha.format(nuevoProfesor.getFechaNacimiento().getTime());
									String fechaIngresoFormato = formatoFecha.format(nuevoProfesor.getFechaIngreso().getTime());
									System.out.println("Nombre: " + nuevoProfesor.getNombre());
									System.out.println("Fecha de nacimiento: " + fechaNacimientoFormato);
									System.out.println("ID profesor: " + nuevoProfesor.getID());
									System.out.println("Sexo: " + nuevoProfesor.getSexo());
									System.out.println("Fecha de ingreso: " + fechaIngresoFormato);
								} else {
									System.out.println("Fecha de ingreso incorrecta. Intente nuevamente.");
								}
							} else {
								System.out.println("Sexo incorrecto. Intente nuevamente.");
							}
						} else {
							System.out.println("Fecha de nacimiento incorrecta. Intente nuevamente.");
						}
					} else {
						System.out.println("Nombre incorrecto. Intente nuevamente.");
					}
					break;
				case "4":
					System.out.println("Dar de alta un alumno");
					System.out.print("Nombre: ");
					String nombreAlumno = leer.nextLine();
					if (procesosPersona.validarNombre(nombreAlumno)) {
						System.out.print("Fecha de nacimiento (formato dd/mm/yyyy): ");
						String fechaNacimientoString = leer.nextLine(); 
						if (procesosPersona.validarFecha(fechaNacimientoString)) {
							String[] partesFecha = fechaNacimientoString.split("/");
							Calendar fechaNacimiento = Calendar.getInstance();
							fechaNacimiento.set(Integer.parseInt(partesFecha[2]), Integer.parseInt(partesFecha[1]) - 1,Integer.parseInt(partesFecha[0]));
							System.out.print("Sexo (H/M): ");
							char sexo = leer.nextLine().toUpperCase().charAt(0);
							if (procesosPersona.validarSexo(sexo)) {
								System.out.print("Semestre: ");
								String semestreCadena = leer.nextLine();
								if (procesosPersona.validarEntero(semestreCadena)) {
									Integer semestre = Integer.parseInt(semestreCadena);
									System.out.print("Generacion: ");
									String generacion = leer.nextLine();
									if (procesosPersona.validarNombre(generacion)) {
										String id = procesosPersona.generaID();
										System.out.println("ID Generado: " + id);
										Estudiante nuevoEstudiante = new Estudiante(nombreAlumno, fechaNacimiento, id,sexo, semestre, generacion);
										estudiantes.add(nuevoEstudiante);
										System.out.println("Estudiante creado exitosamente.");
										SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
										String fechaNacimientoFormato = formatoFecha.format(nuevoEstudiante.getFechaNacimiento().getTime());
										System.out.println("Nombre: " + nuevoEstudiante.getNombre());
										System.out.println("Fecha de nacimiento: " + fechaNacimientoFormato);
										System.out.println("ID estudiante: " + nuevoEstudiante.getID());
										System.out.println("Sexo: " + nuevoEstudiante.getSexo());
										System.out.println("Semestre: " + nuevoEstudiante.getSemestre());
										System.out.println("Generación: " + nuevoEstudiante.getGeneracion());
									} else {
										System.out.println("Generacion incorrecto. Intente nuevamente.");
									}
								} else {
									System.out.println("Semestre incorrecto. Intente nuevamente con un numero entero.");
								}
							} else {
								System.out.println("Sexo incorrecto. Intente nuevamente.");
							}
						} else {
							System.out.println("Fecha de nacimiento incorrecta. Intente nuevamente.");
						}
					} else {
						System.out.println("Nombre incorrecto. Intente nuevamente.");
					}
					break;
				case "5":
					System.out.println("Asignar materias a un profesor");
					if (!carreras.isEmpty()) {
						if (!materias.isEmpty()) {
							if (!profesores.isEmpty()) {
								System.out.println("Lista de profesores:");
								for (Profesor profesor : profesores) {
									System.out.println("ID: " + profesor.getID() + ", Nombre: " + profesor.getNombre());
								}
								System.out.println("Ingrese el ID del profesor al que desea asignarle materias:");
								String idProfesor = leer.nextLine();
								Profesor profesorSeleccionado = procesosEscuela.buscarProfesorPorId(profesores,idProfesor);
								if (profesorSeleccionado != null) {
									System.out.println("Cuantas materias se le asignarán al profesor:");
									System.out.println("Cuantas materias totales: " + materias.size());
									String totalMateriasCadena = leer.nextLine();
									if (procesosPersona.validarEntero(totalMateriasCadena)) {
										Integer totalMaterias = Integer.parseInt(totalMateriasCadena);
										if (totalMaterias <= materias.size()) {
											System.out.println("Seleccione las materias a asignar al profesor:");
											List<Materia> materiasAsignar = new ArrayList<>();
											for (int i = 0; i < totalMaterias; i++) {
												for (int j = 0; j < materias.size(); j++) {
								                    Materia materia = materias.get(j);
													System.out.println("ID: " + materia.getId() + ", Nombre: "+ materia.getNombre());
												}
												System.out.println("Ingrese el ID de la materia: ");
												String idMateria = leer.nextLine();
												Materia materiaSeleccionada = procesosEscuela.buscarMateriaPorId(materias, idMateria);
												if (materiaSeleccionada != null) {
													if (!profesorSeleccionado.getMaterias().contains(materiaSeleccionada)) {
														materiasAsignar.add(materiaSeleccionada);
													} else {
														System.out.println(	"La materia seleccionada ya ha sido asignada a este profesor.");
														i--;
														break;
													}
												} else {
													System.out.println("No se encontró ninguna materia con el ID proporcionado.");
									
													i--;
													break;
												}
											}
											profesorSeleccionado.setMaterias(materiasAsignar);
											profesorSeleccionado.imprimirMateriasAsignadas();
										} else {
											System.out.println("Error, proporciona un número menor o igual al total de materias.");
										}
									} else {
										System.out.println("Error, proporciona un número entero.");
									}
								} else {
									System.out.println("No se encontró ningún profesor con el ID proporcionado.");
								}
							} else {
								System.out.println("No hay profesores registrados en el sistema.");
							}
						} else {
							System.out.println("Error, no existen materias, agrega alguna");
						}
					} else {
						System.out.println("Error, no existen carreras, agrega alguna");
					}
					break;
				case "6":
					System.out.println("Asignar carrera y lista de materias a un alumno");
					if (!carreras.isEmpty()) {
						if (!estudiantes.isEmpty()) {
							System.out.println("Lista de alumnos:");
							for (Estudiante estudiante : estudiantes) {
								System.out.println("ID: " + estudiante.getID() + ", Nombre: " + estudiante.getNombre());
							}
							System.out.println("Ingrese el ID del alumno al que desea asignar una carrera:");
							String idAlumno = leer.nextLine();
							Estudiante alumnoSeleccionado = procesosEscuela.buscarEstudiantePorId(estudiantes,
									idAlumno);
							if (alumnoSeleccionado != null) {
								System.out.println("Lista de carreras:");
								for (Carrera carrera : carreras) {
									System.out.println("ID: " + carrera.getId() + ", Nombre: " + carrera.getNombre());
								}
								System.out.println("Ingrese el ID de la carrera que desea asignar al alumno:");
								String idCarrera = leer.nextLine();
								Carrera carreraSeleccionada = procesosEscuela.buscarCarreraPorId(carreras, idCarrera);
								if (carreraSeleccionada != null) {
									if (procesosEscuela.carreraTieneMaterias(materias, carreraSeleccionada)) {
										alumnoSeleccionado.setCarrera(carreraSeleccionada);
										List<Materia> materiasAsignadas = new ArrayList<>();
										for (Materia materia : materias) {
											if (materia.getCarrera().getId().equals(carreraSeleccionada.getId())) {
												materiasAsignadas.add(materia);
											}
										}
										alumnoSeleccionado.setMaterias(materiasAsignadas);
										alumnoSeleccionado.setCarrera(carreraSeleccionada);
										System.out.println("Carrera asignada al alumno exitosamente.");
										for (Materia materia : materiasAsignadas) {
											System.out.println("ID: " + materia.getId() + ", Nombre: " + materia.getNombre());
										}
									} else {
										System.out.println("Error, la carrera seleccionada no tiene materias disponibles.");
									}
								} else {
									System.out.println("Error, la carrera con el ID ingresado no existe. Por favor, ingrese un ID válido.");
								}
							} else {
								System.out.println("No se encontró ningún alumno con el ID proporcionado.");
							}
						} else {
							System.out.println("No hay alumnos registrados en el sistema.");
						}
					} else {
						System.out.println("Error, no existen carreras, agrega alguna");
					}
					break;
				case "7":
					System.out.println("Editar materias de un alumno");
					if (!estudiantes.isEmpty()) {
						System.out.println("Lista de alumnos:");
						for (Estudiante estudiante : estudiantes) {
							System.out.println("ID: " + estudiante.getID() + ", Nombre: " + estudiante.getNombre());
						}
						System.out.println("Ingrese el ID del alumno cuyas materias desea editar:");
						String idAlumnoEditar = leer.nextLine();
						Estudiante alumnoEditar = procesosEscuela.buscarEstudiantePorId(estudiantes, idAlumnoEditar);
						if (alumnoEditar != null) {
							List<Materia> materiasAlumno = alumnoEditar.getMaterias();
							if (materiasAlumno == null) {
								materiasAlumno = new ArrayList<>();
							}
							if (!materiasAlumno.isEmpty()) {
								System.out.println("Materias asignadas al alumno:");
								for (Materia materia : materiasAlumno) {
									System.out.println("ID: " + materia.getId() + ", Nombre: " + materia.getNombre());
								}
								System.out.println("¿Qué desea hacer?");
								System.out.println("1. Agregar materia");
								System.out.println("2. Eliminar materia");
								System.out.print("Ingrese su opción: ");
								String opcionEditar = leer.nextLine();
								switch (opcionEditar) {
								case "1":
									System.out.println("Lista de materias disponibles:");
									for (Materia materia : materias) {
										System.out
												.println("ID: " + materia.getId() + ", Nombre: " + materia.getNombre());
									}
									System.out.println("Ingrese el ID de la materia que desea agregar:");
									String idMateriaAgregar = leer.nextLine();
									Materia materiaAgregar = procesosEscuela.buscarMateriaPorId(materias,idMateriaAgregar);
									if (materiaAgregar != null) {
										if (!materiasAlumno.contains(materiaAgregar)) {
											materiasAlumno.add(materiaAgregar);
											alumnoEditar.setMaterias(materiasAlumno);
											System.out.println("Materia agregada exitosamente.");
										} else {
											System.out.println("El alumno ya tiene asignada esta materia.");
										}
									} else {
										System.out.println("No se encontró ninguna materia con el ID proporcionado.");
									}
									break;
								case "2":
									System.out.println("Ingrese el ID de la materia que desea eliminar:");
									String idMateriaEliminar = leer.nextLine();
									Materia materiaEliminar = procesosEscuela.buscarMateriaPorId(materiasAlumno,idMateriaEliminar);
									if (materiaEliminar != null) {
										materiasAlumno.remove(materiaEliminar);
										alumnoEditar.setMaterias(materiasAlumno);
										System.out.println("Materia eliminada exitosamente.");
									} else {
										System.out.println("El alumno no tiene asignada ninguna materia con el ID proporcionado.");
									}
									break;
								default:
									System.out.println(
											"Opción inválida. Por favor, ingrese 1 para agregar una materia o 2 para eliminar una materia.");
									break;
								}
							} else {
								System.out.println(
										"El alumno no tiene materias asignadas. Por favor, asigne materias antes de editar.");
							}
						} else {
							System.out.println("No se encontró ningún alumno con el ID proporcionado.");
						}
					} else {
						System.out.println("No hay alumnos registrados en el sistema.");
					}
					break;
				case "8":
					if (!carreras.isEmpty()) {
						if (!materias.isEmpty()) {
							if (!estudiantes.isEmpty()) {
								System.out.println("Agregar calificaciones a un alumno: ");
								System.out.println("Lista de alumnos:");
								for (Estudiante estudiante : estudiantes) {
									System.out.println("ID: " + estudiante.getID() + ", Nombre: " + estudiante.getNombre());
								}
								System.out.println("Ingrese el ID del alumno al que desea agregar calificaciones:");
								String idAlumno = leer.nextLine();
								Estudiante alumnoSeleccionado = procesosEscuela.buscarEstudiantePorId(estudiantes,
										idAlumno);
								if (alumnoSeleccionado != null) {
									List<Materia> materiasAlumno = alumnoSeleccionado.getMaterias();
									if (materiasAlumno != null && !materiasAlumno.isEmpty()) {
										System.out.println("Materias del alumno:");
										for (Materia materia : materiasAlumno) {
											System.out.println(
													"ID: " + materia.getId() + ", Nombre: " + materia.getNombre());
										}
										System.out.println(
												"Ingrese el ID de la materia a la que desea agregar calificaciones:");
										String idMateriaAgregarCalificaciones = leer.nextLine();
										Materia materiaAgregarCalificaciones = procesosEscuela.buscarMateriaPorId(materiasAlumno, idMateriaAgregarCalificaciones);
										if (materiaAgregarCalificaciones != null) {
								            System.out.println("Ingrese las calificaciones para la materia "+ materiaAgregarCalificaciones.getNombre() + ":");
								            MateriaAlumno calificaciones = new MateriaAlumno();
								            System.out.print("Primer Parcial: ");
								            String primerParcialString = leer.nextLine();
								            if (procesosEscuela.esCalificacionValida(primerParcialString)) {
								                double primerParcial = Double.parseDouble(primerParcialString);
								                calificaciones.setPrimerParcial(primerParcial);
								            } else {
								                System.out.println("La calificación debe ser un número entre 0 y 100. Por favor, ingrese nuevamente.");
								                break;
								            }
								            System.out.print("Segundo Parcial: ");
								            String segundoParcialString = leer.nextLine();
								            if (procesosEscuela.esCalificacionValida(segundoParcialString)) {
								                double segundoParcial = Double.parseDouble(segundoParcialString);
								                calificaciones.setSegundoParcial(segundoParcial);
								            } else {
								                System.out.println("La calificación debe ser un número entre 0 y 100. Por favor, ingrese nuevamente.");
								                break;
								            }
								            System.out.print("Proyecto: ");
								            String proyectoString = leer.nextLine();
								            if (procesosEscuela.esCalificacionValida(proyectoString)) {
								                double proyecto = Double.parseDouble(proyectoString);
								                calificaciones.setProyecto(proyecto);
								            } else {
								                System.out.println("La calificación debe ser un número entre 0 y 100. Por favor, ingrese nuevamente.");
								                break;
								            }
								            System.out.print("Examen Final: ");
								            String examenFinalString = leer.nextLine();
								            if (procesosEscuela.esCalificacionValida(examenFinalString)) {
								                double examenFinal = Double.parseDouble(examenFinalString);
								                calificaciones.setExamenFinal(examenFinal);
								            } else {
								                System.out.println("La calificación debe ser un número entre 0 y 100. Por favor, ingrese nuevamente.");
								                break;
								            }
								            calificaciones.setMateria(materiaAgregarCalificaciones);
								            alumnoSeleccionado.agregarCalificaciones(calificaciones);
								            System.out.println("Calificaciones agregadas exitosamente.");
								        } else {
								            System.out.println("No se encontró ninguna materia con el ID proporcionado.");
								        }
									} else {
										System.out.println("El alumno no tiene materias asignadas.");
									}
								} else {
									System.out.println("No se encontró ningún alumno con el ID proporcionado.");
								}
							} else {
								System.out.println("No hay estudiantes registrados en el sistema.");
							}
						} else {
							System.out.println("No hay materias registradas en el sistema.");
						}
					} else {
						System.out.println("No hay carreras registradas en el sistema.");
					}
					break;
				case "9":
					if (!estudiantes.isEmpty()) {
						System.out.println("Ver datos de un alumno");
						System.out.println("Lista de alumnos:");
						for (Estudiante estudiante : estudiantes) {
							System.out.println("ID: " + estudiante.getID() + ", Nombre: " + estudiante.getNombre());
						}
						System.out.println("Ingrese el ID del alumno del que desea ver los datos:");
						String idAlumnoVer = leer.nextLine();
						Estudiante alumnoVer = procesosEscuela.buscarEstudiantePorId(estudiantes, idAlumnoVer);
						if (alumnoVer != null) {
							SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
							System.out.println("Datos del alumno:");
							System.out.println("ID: " + alumnoVer.getID());
							System.out.println("Nombre: " + alumnoVer.getNombre());
							System.out.println("Fecha de nacimiento: "
									+ formatoFecha.format(alumnoVer.getFechaNacimiento().getTime()));
							System.out.println("Sexo: " + alumnoVer.getSexo());
							System.out.println("Semestre: " + alumnoVer.getSemestre());
							System.out.println("Generación: " + alumnoVer.getGeneracion());
							if (alumnoVer.getCarrera() != null) {
								System.out.println("Carrera: " + alumnoVer.getCarrera().getNombre());
							} else {
								System.out.println("Carrera: No asignada");
							}
							List<Materia> materiasAlumno = alumnoVer.getMaterias();
							if (materiasAlumno != null && !materiasAlumno.isEmpty()) {
								System.out.println("Materias asignadas:");
								for (Materia materia : materiasAlumno) {
									System.out.println("- " + materia.getNombre());
									MateriaAlumno calificacionesAlumno = alumnoVer
											.buscarCalificacionesPorMateria(materia);
									if (calificacionesAlumno != null) {
										System.out.println("Calificaciones:");
										System.out
												.println("Primer Parcial: " + calificacionesAlumno.getPrimerParcial());
										System.out.println(
												"Segundo Parcial: " + calificacionesAlumno.getSegundoParcial());
										System.out.println("Proyecto: " + calificacionesAlumno.getProyecto());
										System.out.println("Examen Final: " + calificacionesAlumno.getExamenFinal());
									} else {
										System.out.println("Calificaciones: No registradas");
									}
								}
							} else {
								System.out.println("Materias: No asignadas");
							}
						} else {
							System.out.println("No se encontró ningún alumno con el ID proporcionado.");
						}
					} else {
						System.out.println("No hay alumnos registrados en el sistema.");
					}
					break;
				case "10":
					if (!estudiantes.isEmpty()) {
						System.out.println("Calcular promedio de una materia para un alumno:");
						System.out.println("Lista de alumnos:");
						for (Estudiante estudiante : estudiantes) {
							System.out.println("ID: " + estudiante.getID() + ", Nombre: " + estudiante.getNombre());
						}
						System.out.println("Ingrese el ID del alumno para calcular su promedio:");
						String idAlumnoPromedio = leer.nextLine();
						Estudiante alumnoPromedio = procesosEscuela.buscarEstudiantePorId(estudiantes,
								idAlumnoPromedio);
						if (alumnoPromedio != null) {
							List<Materia> materiasAlumno = alumnoPromedio.getMaterias();
							if (materiasAlumno != null && !materiasAlumno.isEmpty()) {
								System.out.println("Lista de materias del alumno:");
								for (Materia materia : materiasAlumno) {
									System.out.println("ID: " + materia.getId() + ", Nombre: " + materia.getNombre());
								}
								System.out.println("Ingrese el ID de la materia para calcular su promedio:");
								String idMateria = leer.nextLine();
								Materia materiaSeleccionada = procesosEscuela.buscarMateriaPorId(materiasAlumno,idMateria);
								if (materiaSeleccionada != null) {
									MateriaAlumno calificacionesMateria = alumnoPromedio.buscarCalificacionesPorMateria(materiaSeleccionada);
									if (calificacionesMateria != null) {
										double promedioMateria = procesosEscuela.calcularPromedioMateria(calificacionesMateria);
										System.out.println("El promedio del alumno " + alumnoPromedio.getNombre()+ " en la materia " + materiaSeleccionada.getNombre() + " es: "+ promedioMateria);
									} else {
										System.out.println("El alumno no tiene calificaciones registradas en la materia seleccionada.");
									}
								} else {
									System.out.println("No se encontró ninguna materia con el ID proporcionado.");
								}
							} else {
								System.out.println("El alumno no tiene materias asignadas.");
							}
						} else {
							System.out.println("No se encontró ningún alumno con el ID proporcionado.");
						}
					} else {
						System.out.println("No hay alumnos registrados en el sistema.");
					}
					break;
				case "11":
					if (!estudiantes.isEmpty()) {
						System.out.println("Obtener el promedio por alumno en un semestre:");
						System.out.println("Lista de alumnos:");
						for (Estudiante estudiante : estudiantes) {
							System.out.println("ID: " + estudiante.getID() + ", Nombre: " + estudiante.getNombre());
						}
						System.out.println("Ingrese el ID del alumno para calcular su promedio:");
						String idAlumnoPromedio = leer.nextLine();
						Estudiante alumnoPromedio = procesosEscuela.buscarEstudiantePorId(estudiantes,
								idAlumnoPromedio);
						if (alumnoPromedio != null) {
							System.out.println("Ingrese el semestre para calcular el promedio:");
							int semestre = Integer.parseInt(leer.nextLine()); 
							List<Materia> materiasAlumno = alumnoPromedio.getMaterias();
							if (materiasAlumno != null && !materiasAlumno.isEmpty()) {
								double promedioTotal = 0.0;
								int contadorMateriasConCalificaciones = 0;
								for (Materia materia : materiasAlumno) {
									if (materia.getSemestre() == semestre) {
										MateriaAlumno calificacionesMateria = alumnoPromedio.buscarCalificacionesPorMateria(materia);
										if (calificacionesMateria != null) {
											double promedioMateria = procesosEscuela.calcularPromedioMateria(calificacionesMateria);
											promedioTotal += promedioMateria;
											contadorMateriasConCalificaciones++;
										}
									}
								}
								if (contadorMateriasConCalificaciones > 0) {
									promedioTotal /= contadorMateriasConCalificaciones;
									System.out.println("El promedio del alumno " + alumnoPromedio.getNombre()
											+ " en el semestre " + semestre + " es: " + promedioTotal);
								} else {
									System.out.println(
											"El alumno no tiene calificaciones registradas en el semestre seleccionado.");
								}
							} else {
								System.out.println("El alumno no tiene materias asignadas.");
							}
						} else {
							System.out.println("No se encontró ningún alumno con el ID proporcionado.");
						}
					} else {
						System.out.println("No hay alumnos registrados en el sistema.");
					}
					break;
				case "12":
					if (!carreras.isEmpty()) {
						if (!materias.isEmpty()) {
							System.out.println("Lista de carreras:");
							for (Carrera carrera : carreras) {
								System.out.println("ID: " + carrera.getId() + ", Nombre: " + carrera.getNombre());
							}
							System.out.println("Ingrese el ID de la carrera:");
							String idCarrera = leer.nextLine();
							Carrera carreraSeleccionada = procesosEscuela.buscarCarreraPorId(carreras, idCarrera);
							if (carreraSeleccionada != null) {
								System.out.println("Ingrese el semestre:");
								int semestre = Integer.parseInt(leer.nextLine());
								List<Estudiante> estudiantesCarreraSemestre = new ArrayList<>();
								for (Estudiante estudiante : estudiantes) {
									if (estudiante.getCarrera().equals(carreraSeleccionada)) {
										List<Materia> materiasEstudiante = estudiante.getMaterias();
										for (Materia materia : materiasEstudiante) {
											if (materia.getSemestre() == semestre) {
												estudiantesCarreraSemestre.add(estudiante);
												break;
											}
										}
									}
								}
								if (!estudiantesCarreraSemestre.isEmpty()) {
									double promedioTotalSemestre = 0.0;
									int contadorEstudiantes = 0;
									for (Estudiante estudiante : estudiantesCarreraSemestre) {
										List<Materia> materiasEstudiante = estudiante.getMaterias();
										double promedioEstudiante = 0.0;
										int contadorMaterias = 0;
										for (Materia materia : materiasEstudiante) {
											if (materia.getSemestre() == semestre) {
												MateriaAlumno calificacionesMateria = estudiante.buscarCalificacionesPorMateria(materia);
												if (calificacionesMateria != null) {
													promedioEstudiante += procesosEscuela.calcularPromedioMateria(calificacionesMateria);
													contadorMaterias++;
												}
											}
										}
										if (contadorMaterias > 0) {
											promedioEstudiante /= contadorMaterias;
											promedioTotalSemestre += promedioEstudiante;
											contadorEstudiantes++;
										}
									}
									if (contadorEstudiantes > 0) {
										promedioTotalSemestre /= contadorEstudiantes;
										System.out.println("El promedio del semestre " + semestre + " para la carrera "
												+ carreraSeleccionada.getNombre() + " es: " + promedioTotalSemestre);
									} else {
										System.out.println(
												"No hay estudiantes con materias registradas en el semestre seleccionado para la carrera especificada.");
									}
								} else {
									System.out.println(
											"No hay estudiantes en la carrera seleccionada para el semestre especificado.");
								}
							} else {
								System.out.println("La carrera especificada no existe.");
							}
						} else {
							System.out.println("Error, no existen materias, agrega alguna.");
						}
					} else {
						System.out.println("Error, no existen carreras, agrega alguna.");
					}
					break;
				case "13":
				    if (!carreras.isEmpty()) {
				        System.out.println("Lista de carreras:");
				        for (Carrera carrera : carreras) {
				            System.out.println("ID: " + carrera.getId() + ", Nombre: " + carrera.getNombre());
				        }
				        System.out.println("Ingrese el ID de la carrera:");
				        String idCarrera = leer.nextLine();
				        Carrera carreraSeleccionada = procesosEscuela.buscarCarreraPorId(carreras, idCarrera);
				        if (carreraSeleccionada != null) {
				            System.out.println("Ingrese el semestre:");
				            int semestre = Integer.parseInt(leer.nextLine());
				            List<Materia> materiasSemestreCarrera = new ArrayList<>();
				            for (Materia materia : materias) {
				                if (materia.getSemestre() == semestre && materia.getCarrera().equals(carreraSeleccionada)) {
				                    materiasSemestreCarrera.add(materia);
				                }
				            }
				            if (!materiasSemestreCarrera.isEmpty()) {
				                System.out.println("Lista de materias en el semestre y la carrera seleccionada:");
				                for (Materia materia : materiasSemestreCarrera) {
				                    System.out.println("ID: " + materia.getId() + ", Nombre: " + materia.getNombre());
				                }
				                System.out.println("Ingrese el ID de la materia:");
				                String idMateria = leer.nextLine();
				                Materia materiaSeleccionada = procesosEscuela.buscarMateriaPorId(materiasSemestreCarrera, idMateria);
				                if (materiaSeleccionada != null) {
				                    double promedioMateria = 0.0;
				                    int contadorEstudiantes = 0;
				                    for (Estudiante estudiante : estudiantes) {
				                        if (estudiante.getCarrera().equals(carreraSeleccionada)) {
				                            MateriaAlumno calificacionesMateria = estudiante.buscarCalificacionesPorMateria(materiaSeleccionada);
				                            if (calificacionesMateria != null && calificacionesMateria.getMateria().getSemestre() == semestre) {
				                                promedioMateria += procesosEscuela.calcularPromedioMateria(calificacionesMateria);
				                                contadorEstudiantes++;
				                            }
				                        }
				                    }
				                    if (contadorEstudiantes > 0) {
				                        promedioMateria /= contadorEstudiantes;
				                        System.out.println("El promedio de la materia " + materiaSeleccionada.getNombre() + " en el semestre " + semestre + " para la carrera " + carreraSeleccionada.getNombre() + " es: " + promedioMateria);
				                    } else {
				                        System.out.println("No hay estudiantes con calificaciones registradas en la materia seleccionada para el semestre especificado.");
				                    }
				                } else {
				                    System.out.println("La materia especificada no existe.");
				                }
				            } else {
				                System.out.println("No hay materias en tal semestre en la carrera seleccionada.");
				            }
				        } else {
				            System.out.println("La carrera especificada no existe.");
				        }
				    } else {
				        System.out.println("No hay carreras registradas en el sistema.");
				    }
				    break;
				case "14":
				    if (!carreras.isEmpty()) {
				        System.out.println("Lista de carreras:");
				        for (Carrera carrera : carreras) {
				            System.out.println("ID: " + carrera.getId() + ", Nombre: " + carrera.getNombre());
				        }
				        System.out.println("Ingrese el ID de la carrera:");
				        String idCarrera = leer.nextLine();
				        Carrera carreraSeleccionada = procesosEscuela.buscarCarreraPorId(carreras, idCarrera);
				        if (carreraSeleccionada != null) {
				            double promedioCarrera = 0.0;
				            int contadorMaterias = 0;
				            int contadorEstudiantes = 0;
				            for (Estudiante estudiante : estudiantes) {
				                if (estudiante.getCarrera().equals(carreraSeleccionada)) {
				                    List<Materia> materiasEstudiante = estudiante.getMaterias();
				                    for (Materia materia : materiasEstudiante) {
				                        MateriaAlumno calificacionesMateria = estudiante.buscarCalificacionesPorMateria(materia);
				                        if (calificacionesMateria != null) {
				                            promedioCarrera += procesosEscuela.calcularPromedioMateria(calificacionesMateria);
				                            contadorMaterias++;
				                        }
				                    }
				                    contadorEstudiantes++;
				                }
				            }
				            if (contadorEstudiantes > 0 && contadorMaterias > 0) {
				                promedioCarrera /= contadorMaterias * contadorEstudiantes;
				                System.out.println("El promedio de la carrera " + carreraSeleccionada.getNombre() + " es: " + promedioCarrera);
				            } else {
				                System.out.println("No hay estudiantes con calificaciones registradas en la carrera seleccionada.");
				            }
				        } else {
				            System.out.println("La carrera especificada no existe.");
				        }
				    } else {
				        System.out.println("No hay carreras registradas en el sistema.");
				    }
				    break;
				case "15":
				
				    if (!materias.isEmpty()) {
				        util.guardaArchivo("Materias", materias);
				    } else {
				        System.out.println("No hay información de materias para guardar.");
				    }
				    if (!carreras.isEmpty()) {
				        util.guardaArchivo("Carreras", carreras);
				    } else {
				        System.out.println("No hay información de carreras para guardar.");
				    }
				    if (!profesores.isEmpty()) {
				        util.guardaArchivo("Profesores", profesores);
				    } else {
				        System.out.println("No hay información de profesores para guardar.");
				    }
				    if (!estudiantes.isEmpty()) {
				        util.guardaArchivo("Estudiantes", estudiantes);
				    } else {
				        System.out.println("No hay información de estudiantes para guardar.");
				    }
				    break;
				case "16":
					if (util.existeArchivo("Carreras")) {
					    System.out.println(util.leerArchivo("Carreras"));
					} 
					if (util.existeArchivo("Materias")) {
					    System.out.println(util.leerArchivo("Materias"));
					} 
					if (util.existeArchivo("Profesores")) {
					    System.out.println(util.leerArchivo("Profesores"));
					} 
					if (util.existeArchivo("Estudiantes")) {
					    System.out.println(util.leerArchivo("Estudiantes"));
					}
					if (!util.existeArchivo("Carreras") && !util.existeArchivo("Materias") && !util.existeArchivo("Profesores") && !util.existeArchivo("Estudiantes")) {
					    System.out.println("No hay archivos para leer.");
					}
					break;


				case "17":
					salir = true;
					System.out.println("Fin del programa");
					break;
				default:
					System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
					break;
				}
			} else {
				System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
			}
		}
		leer.close();
	}


}

