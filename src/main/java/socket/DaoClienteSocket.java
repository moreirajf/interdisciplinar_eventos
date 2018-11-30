package socket;

import models.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class DaoClienteSocket implements ClienteDao{

    ObjectInputStream fEntrada;
    Socket sc;
    ObjectOutputStream fSaida;
    public DaoClienteSocket(String host) throws Exception{
        sc = new Socket(InetAddress.getByName(host),5005);
        fSaida = new ObjectOutputStream(sc.getOutputStream());
        fEntrada = new ObjectInputStream(sc.getInputStream());
    }


    public ArrayList<Evento> getAllEventos(){
        try{
        String mensagem="GETALLEVENTOS";
        fSaida.writeUTF(mensagem);
        fSaida.flush();
        ArrayList<Evento> ar=(ArrayList<Evento>)fEntrada.readObject();
        return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Evento> getEventosByOrganizador(String organizador){
        try{
            String mensagem="GETALLEVENTOS_ORG";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeUTF(organizador);
            fSaida.flush();
            ArrayList<Evento> ar=(ArrayList<Evento>)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Local> getAllLocais() {
        try{
            String mensagem="GETALLLOCAIS";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            ArrayList<Local> ar=(ArrayList<Local>)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Evento getEventosById(int evento) {
        try{
            String mensagem="GETEVENTO_ID";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.write(evento);
            fSaida.flush();
            Evento ar=(Evento)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Local getLocalEvento(int evento) {
        try{
            String mensagem="GETLOCAL_EVENTO";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.write(evento);
            fSaida.flush();
            Local ar=(Local)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Local getLocalById(int local) {
        try{
            String mensagem="GETLOCAL_COD";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.write(local);
            fSaida.flush();
            Local ar=(Local)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void salvarLocal(Local local) {
        try{
            String mensagem="SAVE_LOCAL";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeObject(local);
            fSaida.flush();
            }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deletarLocal(Local local) {
        try{
            String mensagem="DELETE_LOCAL";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeObject(local);
            fSaida.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }    }

    public ArrayList<Local> buscarLocal(String nome) {
        try{
            String mensagem="SEARCHLOCAL_NOME";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeUTF(nome);
            fSaida.flush();
            ArrayList<Local> ar=(ArrayList<Local>)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void salvarEvento(Evento evento) {
        try{
            String mensagem="SAVE_EVENTO";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeObject(evento);
            fSaida.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deletarEvento(Evento evento) {
        try{
            String mensagem="DELETE_EVENTO";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeObject(evento);
            fSaida.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Evento> buscarEventos(String nome) {
        try{
            String mensagem="SEARCHEVENTO_NOME";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeUTF(nome);
            fSaida.flush();
            ArrayList<Evento> ar=(ArrayList<Evento>)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void salvarTipoIngresso(TipoIngresso ingresso) {
        try{
            String mensagem="SAVE_TIPOINGRESSO";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeObject(ingresso);
            fSaida.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deletarTipoIngresso(TipoIngresso ingresso) {
        try{
            String mensagem="DELETE_TIPOINGRESSO";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeObject(ingresso);
            fSaida.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<TipoIngresso> buscarTipoIngresso(String nome, String organizador) {
        try{
            String mensagem="SEARCHTIPOINGRESSO_NOME_ORG";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeUTF(nome);
            fSaida.flush();
            fSaida.writeUTF(organizador);
            fSaida.flush();
            ArrayList<TipoIngresso> ar=(ArrayList<TipoIngresso>)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<TipoIngresso> getTipoIngressosOrganizador(String organizador) {
        try{
            String mensagem="GETALLTIPOINGRESSOS_ORG";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeUTF(organizador);
            fSaida.flush();
            ArrayList<TipoIngresso> ar=(ArrayList<TipoIngresso>)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<TipoIngresso> getTipoIngressoEvento(int codigo) {
        try{
            String mensagem="GETALLTIPOINGRESSOS_COD";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.write(codigo);
            fSaida.flush();
            ArrayList<TipoIngresso> ar=(ArrayList<TipoIngresso>)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public TipoIngresso getTipoIngresso(int id) {
        try{
            String mensagem="GETTIPOINGRESSOS_COD";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.write(id);
            fSaida.flush();
            TipoIngresso ar=(TipoIngresso)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Evento> getEventosPatrocinio(String patrocinador) {
        //not implemented yet
        return null;
    }

    public boolean isPatrocinado(int evento, String patrocinador) {
        try{
            String mensagem="ISPATROCINADO_COD_PAT";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.write(evento);
            fSaida.flush();
            fSaida.writeUTF(patrocinador);
            fSaida.flush();
            boolean b=fEntrada.readBoolean();
            System.out.println(b);
            return b;}
        catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void removerPatrocinio(int evento, String patrocinador) {
        try{
            String mensagem="DELETE_PAT_EVENTO";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.write(evento);
            fSaida.flush();
            fSaida.writeUTF(patrocinador);
            fSaida.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void adicionarPatrocinio(int evento, String patrocinador) {
        try{
            String mensagem="ADD_PAT_EVENTO";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.write(evento);
            fSaida.flush();
            fSaida.writeUTF(patrocinador);
            fSaida.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean criarOrganizador(Organizador organizador) {
        try{
            String mensagem="CREATE_ORG";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeObject(organizador);
            fSaida.flush();
            return fEntrada.readBoolean();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean criarPatrocinador(Patrocinador organizador) {
        try{
            String mensagem="CREATE_PAT";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeObject(organizador);
            fSaida.flush();
            return fEntrada.readBoolean();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Organizador loginOrganizador(String usuario, String senha) {


        try{
            String mensagem="LOGIN_ORG";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeUTF(usuario);
            fSaida.flush();
            fSaida.writeUTF(senha);
            fSaida.flush();
            Organizador ar=(Organizador)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;


    }

    public Patrocinador loginPatrocinador(String usuario, String senha) {
        try{
            String mensagem="LOGIN_PAT";
            fSaida.writeUTF(mensagem);
            fSaida.flush();
            fSaida.writeUTF(usuario);
            fSaida.flush();
            fSaida.writeUTF(senha);
            fSaida.flush();
            Patrocinador ar=(Patrocinador)fEntrada.readObject();
            return ar;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
