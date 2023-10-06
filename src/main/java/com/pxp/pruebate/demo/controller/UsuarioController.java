package com.pxp.pruebate.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pxp.pruebate.demo.entity.UsuarioEntity;
import com.pxp.pruebate.demo.repository.UsuarioRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/h2/usuario")
public class UsuarioController {

    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "crearUsuario", method = RequestMethod.POST)
    public String createStudent(@RequestBody String Nombreusuario){
    	String url = "https://gorest.co.in/public/v2/users";
    	
    	RestTemplate restTemplate = new RestTemplate();
    	UsuarioEntity[] usuarios =  restTemplate.getForObject(url, UsuarioEntity[].class);
    	Boolean existe = false;
    	for(int i=0; i < usuarios.length; i ++) {
    		if(Nombreusuario.equals(usuarios[i].getName()) && usuarios[i].getGender().equals("active")) {
    			existe = true;
            	UsuarioEntity usuario = new UsuarioEntity();
            	usuario.setName(usuarios[i].getName());
            	usuario.setEmail(usuarios[i].getEmail());
            	usuario.setId(usuarios[i].getId());
            	usuario.setGender(usuarios[i].getGender());
            	usuario.setStatus(usuarios[i].getStatus());
            	usuarioRepository.save(usuario);	
    		}
    	}
    	if (existe == true) {

           return "usuario creado";
    		
    	}else {
    		return "el usuario no existe o se encuentra inactivo";
    	}

    }

    @RequestMapping(value = "ListarUsuarios", method = RequestMethod.GET)
    public Flux<UsuarioEntity> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @RequestMapping(value = "updateUsuario", method = RequestMethod.PUT)
    public Mono<UsuarioEntity> updateUsuario(@RequestBody UsuarioEntity usuario){
    	return usuarioRepository.save(usuario) ;
    }


}
