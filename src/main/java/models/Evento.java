package models;

import java.io.Serializable;

public class Evento implements Serializable{
    private int codigo;
    private String descricao;
    private String fim;
    private String inicio;
    private String nome;
    private String capacidade;
    private int local_codigo;
    private String organizador_cpf_cnpj;
    private String img_link1;
    private String img_link2;

    public Evento(int codigo, String descricao, String fim, String inicio, String nome, String capacidade, int local_codigo, String organizador_cpf_cnpj, String img_link1, String img_link2) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.fim = fim;
        this.inicio = inicio;
        this.nome = nome;
        this.capacidade = capacidade;
        this.local_codigo = local_codigo;
        this.organizador_cpf_cnpj = organizador_cpf_cnpj;
        this.img_link1 = img_link1;
        this.img_link2 = img_link2;
    }

    public Evento(String descricao, String fim, String inicio, String nome, String capacidade, int local_codigo, String organizador_cpf_cnpj, String img_link1, String img_link2) {
        this.descricao = descricao;
        this.fim = fim;
        this.inicio = inicio;
        this.nome = nome;
        this.capacidade = capacidade;
        this.local_codigo = local_codigo;
        this.organizador_cpf_cnpj = organizador_cpf_cnpj;
        this.img_link1 = img_link1;
        this.img_link2 = img_link2;
    }

    public Evento(int codigo) {
        this.codigo = codigo;
    }

    public Evento() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public int getLocal_codigo() {
        return local_codigo;
    }

    public void setLocal_codigo(int local_codigo) {
        this.local_codigo = local_codigo;
    }

    public String getOrganizador_cpf_cnpj() {
        return organizador_cpf_cnpj;
    }

    public void setOrganizador_cpf_cnpj(String organizador_cpf_cnpj) {
        this.organizador_cpf_cnpj = organizador_cpf_cnpj;
    }

    public String getImg_link1() {
        return img_link1;
    }

    public void setImg_link1(String img_link1) {
        this.img_link1 = img_link1;
    }

    public String getImg_link2() {
        return img_link2;
    }

    public void setImg_link2(String img_link2) {
        this.img_link2 = img_link2;
    }
}