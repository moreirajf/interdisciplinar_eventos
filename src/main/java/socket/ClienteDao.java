package socket;
import models.*;

import java.util.ArrayList;
import java.util.List;

public interface ClienteDao {
    public ArrayList<Evento> getAllEventos();
    public ArrayList<Evento> getEventosByOrganizador(String organizador);
    public ArrayList<Local> getAllLocais();
    public void salvarLocal(Local local);//se codigo estiver setado => comando update;
    public void deletarEvento(Local local);
    public ArrayList<Local> buscarLocal(String nome);

    public void salvarEvento(Evento evento);//se codigo estiver setado => comando update;
    public void deletarEvento(Evento evento);
    public ArrayList<Evento> buscarEventos(String nome);
    public void salvarTipoIngresso(TipoIngresso ingresso);//se codigo estiver setado => comando update;
    public void deletarTipoIngresso(TipoIngresso ingresso);
    public ArrayList<TipoIngresso> buscarTipoIngresso(String nome,String organizador);

    public ArrayList<Evento> getEventosPatrocinio(String patrocinador);
    public boolean isPatrocinado(Evento evento, String patrocinador);
    public void removerPatrocinio(Evento evento, String patrocinador);
    public void adicionarPatrocinio(Evento evento, String patrocinador);

    public boolean criarOrganizador(Organizador organizador);

    public boolean criarPatrocinador(Patrocinador organizador);
    public Local getLocalEvento(int evento);
    public Evento getEventosById(int evento);
    public ArrayList<TipoIngresso> getTipoIngressoEvento(String organizador);
    public TipoIngresso getTipoIngresso(int id);

}
