package com.ads.projetoengenhariasoftware.controller;

import com.ads.projetoengenhariasoftware.dados.JPAUtil;
import com.ads.projetoengenhariasoftware.dados.PessoaDAO;
import com.ads.projetoengenhariasoftware.model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MasterController {

    @FXML
    private BarChart<String, Number> barBarra;

    @FXML
    private CheckBox ckBranco;

    @FXML
    private CheckBox ckFeminino;

    @FXML
    private CheckBox ckNaoBinario;

    @FXML
    private CheckBox ckOutros;

    @FXML
    private CheckBox ckPardo;

    @FXML
    private CheckBox ckPovosOrginarios;

    @FXML
    private CheckBox ckPreto;

    @FXML
    private CheckBox ckTodosGenero;

    @FXML
    private CheckBox ckTodosRaca;

    @FXML
    private CheckBox ckTransgenero;

    @FXML
    private CheckBox ckmasculino;
    @FXML
    private PieChart piePizza;

    public void exibirGrafico() {
        limparGrafico();
        EntityManager em = new JPAUtil().getEntityManager();
        PessoaDAO pessoaDAO = new PessoaDAO(em);
        List<Pessoa> pessoas = pessoaDAO.pessoas();
        ObservableList<PieChart.Data> obpessoas = FXCollections.observableArrayList();

        List<String> filtros = new ArrayList<>();
        filtros.add(ckmasculino.isSelected()?ckmasculino.getText().toUpperCase():"");
        filtros.add(ckFeminino.isSelected()?ckFeminino.getText().toUpperCase():"");
        filtros.add(ckNaoBinario.isSelected()?ckNaoBinario.getText().toUpperCase():"");
        filtros.add(ckTransgenero.isSelected()? ckTransgenero.getText().toUpperCase():"");
        filtros.add(ckOutros.isSelected()?ckOutros.getText().toUpperCase():"");


        agruparDados(pessoas, obpessoas, Pessoa::getGeneroString);
        mesclar(barBarra,obpessoas,filtros);

    }



    void mesclar(BarChart<String, Number> barBarra, ObservableList<PieChart.Data> obpessoas, List<String> filtros){

        for (String filtro: filtros){

            if(filtro != ""){
                XYChart.Series<String, Number> serie1 = new XYChart.Series<>();
                serie1.setName(filtro);

                obpessoas.stream().filter(data -> filtro.equals(data.getName()))
                        .forEach(data -> serie1.getData()
                                .add(new XYChart.Data<>("",data.getPieValue())));

                barBarra.getData().add(serie1);

            }

        }

    }

    void agruparDados(List<Pessoa> pessoas, ObservableList<PieChart.Data> obpessoas, Function<Pessoa, String> parametro){
        pessoas.stream()
                .collect(Collectors.groupingBy(parametro, Collectors.counting()))
                .forEach((genero, count) -> obpessoas.add(new PieChart.Data(genero.toString(), count)));
        piePizza.setData(obpessoas);
        System.out.println(obpessoas);
    }

    @FXML
    private void limparGrafico() {
        barBarra.getData().clear();
    }

}



//        barBarra.setTitle("Grafico de Mesclagem de dados");
//        barBarra.getXAxis().setLabel("Categorias");
//        barBarra.getYAxis().setLabel("Qnt");

//        pessoas.stream()
//                .filter(p -> checkGenero().equals(p.getGenero()))  // Filtrando pelo gênero selecionado
//                .collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.counting()))
//                .forEach((genero, count) -> obpessoas.add(new PieChart.Data(genero.toString(), count)));


//        pessoas.stream()
//                .collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.counting()))
//                .forEach((genero, count) -> obpessoas.add(new PieChart.Data(genero.toString(), count)));
//        piePizza.setData(obpessoas);
//        System.out.println(obpessoas);
//
