package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;




@Service
public class UsuarioDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;


}
