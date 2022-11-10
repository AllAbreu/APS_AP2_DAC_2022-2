package bean;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;


import dao.JogoDAO;
import entidade.Jogo;

@ManagedBean
public class JogoBean {

	private Jogo jogo = new Jogo();
	private List<Jogo> lista;
	
	
	public String salvar() {	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Objeto salvo com sucesso."));
		
		jogo.MaiorValor();
		
		JogoDAO.salvar(jogo);
		
		jogo = new Jogo();

		
		return null;
	}
	
	public void onRowEdit(RowEditEvent<Jogo> event) {
		try {
			
			JogoDAO.editar(event.getObject());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Edição realizado com sucesso!"));
			
		} catch (Exception e) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Edição não realizada!"));
			e.printStackTrace();
		}	
    }

    public void onRowCancel(RowEditEvent<Jogo> event) {
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelado", "Edição cancelada com sucesso!"));
    }

	public List<Jogo> getLista() {
		if (lista == null) {
			lista = JogoDAO.listar();
		}
		return lista;
	}
	
	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}
	
	public String excluir(Jogo j) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Objeto excluído com sucesso."));
		JogoDAO.excluir(j);
		lista = JogoDAO.listar();
		return null;
	}
	
//	public String maior(Jogo j) {
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,  "Valor", "É o maior numero entre as Valor 1 a valor 5."));
//		Jogo.
//		
//		return null;
//	}
	
	
	public Jogo getJogo() {
		return jogo;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
	
}
