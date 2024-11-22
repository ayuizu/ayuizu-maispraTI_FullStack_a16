package com.example.teste.service;

import com.example.teste.dto.ProdutoDTO;
import com.example.teste.model.Produto;
import com.example.teste.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void criarProduto(ProdutoDTO dto){
        var produto = new Produto();
        produto.setDescricao(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        produtoRepository.save(produto);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarProduto(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setNome(produtoDTO.getNome());
            produto.setDescricao(produtoDTO.getDescricao());
            produto.setPreco(produtoDTO.getPreco());
            produto.setQuantidade(produtoDTO.getQuantidade());

            produtoRepository.save(produto);
        }
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}
