package com.vacantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vacantes.entity.Categoria;
import com.vacantes.services.IntCategoriaService;

@RequestMapping("/categorias")
@Controller
public class CategoriasController {
	@Autowired
	private IntCategoriaService categoriasService;
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idCategoria, Model model) {
		Categoria categoria = categoriasService.buscar(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@GetMapping("/eliminar")
	public String eliminar (@RequestParam("id") int idCategoria, RedirectAttributes attribute) {
		categoriasService.eliminar(idCategoria);
		attribute.addFlashAttribute("msg", "Categoria Eliminada");
		return "redirect:/categorias/index";
		
	}
	
	@PostMapping("/guardar")
	public String guardar(Categoria categoria,RedirectAttributes model) {
		
		//categoria.setId(categoriasService.listaCategorias().size() + 1);
		categoriasService.guardar(categoria);
		model.addFlashAttribute("msg", "¡La Categoría se guardo con exito!");
		return "redirect:/categorias/index";
	}
	
	/*@PostMapping("/guardar")
	public String guardar(@RequestParam("nombre")String nombre, 
			@RequestParam("descripcion")String descripcion, Model model) {
		Categoria c=new Categoria();
		c.setId(categoriasService.listaCategorias().size() + 1);
		c.setNombre(nombre);
		c.setDescripcion(descripcion);
		categoriasService.guardar(c);
		
		List<Categoria> lista= categoriasService.listaCategorias();
		model.addAttribute("categorias", lista);
		return "categorias/listCategorias";
	}*/
	
	@GetMapping("/crear")
	public String crear(Categoria categoria) {
	return "categorias/formcategoria";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categoria> lista = categoriasService.buscarTodas(page);
	model.addAttribute("categorias", lista);
	model.addAttribute("total", categoriasService.totalRegistros()	);
	return "categorias/listCategorias";
	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista= categoriasService.listaCategorias();
		System.out.println(lista);
		model.addAttribute("categorias", lista);
		
		for(Categoria c: lista) {
			System.out.println(c.getId());
			System.out.println(c.getNombre());
			System.out.println(c.getDescripcion());
		}
		model.addAttribute("total", lista.size());
		return "categorias/listCategorias";
	}
	
	

}
