package com.juancaro.servicios;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancaro.modelos.Articulo;
import com.juancaro.modelos.Usuario;
import com.juancaro.repositorios.RepositorioArticulos;
import com.juancaro.repositorios.RepositorioUsuarios;


@Service
public class ServicioArticulos {

    @Autowired
    private RepositorioArticulos repositorioArticulos;
    
    @Autowired
    private RepositorioUsuarios repositorioUsuarios;
    
    @Autowired
    private ServicioFavoritos servicioFavoritos;
    
    
    public Articulo crear(Articulo articulo, Long idUsuario) {
        Usuario usuario = repositorioUsuarios.findById(idUsuario).orElse(null);

        articulo.setCreador(usuario);
        return this.repositorioArticulos.save(articulo);
    }
    
    public Articulo obtenerArticuloPorId(Long id) {
        return repositorioArticulos.findById(id).map(articulo -> {
        if (articulo.getCreador() != null) {
        articulo.getCreador().getNombre(); 
        } else {
            articulo.setCreador(new Usuario());
        }
        return articulo;
        }).orElse(null);
    }
    
    public List<Articulo> obtenerTodas(){
        return (List<Articulo>) this.repositorioArticulos.findAll();
    }
    
    public Articulo actualizar(Articulo articulo) {
        return this.repositorioArticulos.save(articulo);
    }
    
    public void eliminarPorId(Long id) {
        List<Usuario> usuarios = (List<Usuario>) this.repositorioUsuarios.findAll();
        
        for(Usuario usuario : usuarios) {
            this.servicioFavoritos.quitarFavorito(usuario.getId(), id);
        }
        this.repositorioArticulos.deleteById(id);
        
    }
}
