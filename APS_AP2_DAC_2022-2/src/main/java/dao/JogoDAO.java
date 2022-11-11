package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;



public class JogoDAO {

	public static void salvar(Jogo j) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Jogo j) throws Exception {
		try {
			Date data = new Date();
			j.setDataCadastro(data);
			
			j.maiorValor();
			
			EntityManager em = JPAUtil.criarEntityManager();
			em.getTransaction().begin();
			em.merge(j);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}
	
	public static void excluir(Jogo j) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		j = em.find(Jogo.class, j.getId());
		em.remove(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Jogo> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select j from Jogo j");
		List<Jogo> lista = q.getResultList();
		em.close();
		return lista;
	}
	
//	public static void maior(Jogo j) {
//		EntityManager em = JPAUtil.criarEntityManager();
//		Query q = em.createQuery("select j from Jogo j");
//		List<Jogo> lista = q.getResultList();
//		em.close();
//		return ;
//	}
	
//	public static List<Jogo> listarMaior(){
//		EntityManager em = JPAUtil.criarEntityManager();
//		Query q = em.createNamedQuery("Jogo.listarValor");
//		List<Jogo> lista = q.getResultList();
//		em.close();
//		return lista;
//	}
}
