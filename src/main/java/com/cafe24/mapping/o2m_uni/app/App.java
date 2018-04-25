package com.cafe24.mapping.o2m_uni.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cafe24.mapping.o2m_uni.domain.Member;
import com.cafe24.mapping.o2m_uni.domain.Team;

public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mappingtest");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			
			Member member1 = new Member();
			member1.setName("member1");

			Member member2 = new Member();
			member2.setName("member2");
			
			Team team1 = new Team();
			team1.setName("team1");
			team1.getMembers().add(member1);
			team1.getMembers().add(member2);
			
			em.persist(member1); // insert member1
			em.persist(member2); // insert member2
			
			em.persist(team1); // insert team1
							   // update member1's FK
							   // update member2's FK
			
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		tx.commit();

		em.close();

		emf.close();

	}
}
