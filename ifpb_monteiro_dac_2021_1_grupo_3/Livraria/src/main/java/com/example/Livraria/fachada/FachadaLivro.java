package com.example.Livraria.fachada;

import java.awt.Image;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Livraria.model.Categoria;
import com.example.Livraria.model.Editora;
import com.example.Livraria.model.Livro;
import com.example.Livraria.repositorio.LivroRepositorio;

@Service
public class FachadaLivro {

	@Autowired
	private LivroRepositorio livroRepositorio;

	public void cadastrarLivro(String tituloLivro, List<Categoria> categoria, String descricao, BigDecimal preco,
			Float margemX, Float margemY, String edicao, int anoLancamento, Editora editora, List<Image> fotosLivro,
			List<String> autores,Integer quantidade) {
		Livro livro = new Livro(tituloLivro, categoria, descricao, preco, margemX, margemY, edicao, anoLancamento,
				editora, fotosLivro,autores ,quantidade);
		livroRepositorio.save(livro);
	}

	public void alterarLivro(String isbn, String tituloLivro, String descricao, BigDecimal preco, Float margemX,
			Float margemY, String edicao, Integer anoLancamento, Editora editora, Integer quantidadeEstoque) {
		Livro livro = livroRepositorio.findByISBN(isbn);
		if (tituloLivro != null) {
			livro.setTituloLivro(tituloLivro);
		}if (descricao != null) {
			livro.setDescricao(descricao);
		}if (preco != null) {
			livro.setPreco(preco);
		}if (margemX != null) {
			livro.setMargemX(margemX);
		}if (margemY != null) {
			livro.setMargemY(margemY);
		}if (edicao != null) {
			livro.setEdicao(edicao);
		}if (anoLancamento != null) {
			livro.setAnoLancamento(anoLancamento);
		}if (editora != null) {
			livro.setEditora(editora);
		}if (quantidadeEstoque != null) {
			livro.setQuantidadeEstoque(quantidadeEstoque);
		}
		livroRepositorio.save(livro);
	}

	public List<Livro> listarLivros() {
		return livroRepositorio.findAll();
	}
}
