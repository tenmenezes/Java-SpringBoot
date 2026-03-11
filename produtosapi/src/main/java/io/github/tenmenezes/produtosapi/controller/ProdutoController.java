package io.github.tenmenezes.produtosapi.controller;

import io.github.tenmenezes.produtosapi.model.Produto;
import io.github.tenmenezes.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Essa annotation diz para o spring que essa classe ira receber requisições rest
@RestController
// Diz qual será a URL Base deste Controller
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // tudo que se envia ou recebe de um servidor rest é chamado de recurso
    @PostMapping // envia dados ao servidor
    public Produto salvarProduto(@RequestBody Produto produto){
        // @RequestBody é uma annotation para testes,
        // indicando que irá receber dados do corpo via postman
        System.out.println("Produto recebeido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable String id) {
//        Optional<Produto> produto = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null;

        return  produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarProdutoPorId(@PathVariable String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizarProduto(@PathVariable String id,
                                 @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam String nome) {
        return produtoRepository.findByNome(nome);
    }
}
