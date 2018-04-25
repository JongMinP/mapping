package com.cafe24.mapping.m2m.uni.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cafe24.mapping.m2m.uni.domain.Member;
import com.cafe24.mapping.m2m.uni.domain.Product;

public class App {
	public static void main(String[] args) {

		// 1. Entity Manager Factory 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mappingtest");

		// 2. Entity Manager 생성
		EntityManager em = emf.createEntityManager();

		// 3. get 트랜잭션
		EntityTransaction tx = em.getTransaction();

		// 4. tx Begins
		tx.begin();

		// 5. Business Logic
		try {
			
			testSave(em);
			testFind(em);
//			testInverse(em);
			

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		// 6. tx commit
		tx.commit();

		// 7 Entity Manager Close
		em.close();

		// 8. Entity Manager Factory 종료
		emf.close(); // 설정 잘못되나 설정이 안되어있으면 에러남
	}
	
	private static void testSave(EntityManager em) {
		
		Product productA = new Product();
		productA.setName("상품A");
		em.persist(productA);
		
		Member member1 = new Member();
		member1.setName("회원1");
		em.persist(member1);
		
		
		// 연관관계 설정
		member1.getProducts().add(productA);
		
	}
	
	private static void testFind(EntityManager em) {
		Member member = em.find(Member.class, 1L);
		
		// 객체 그래프 탐색
		List<Product> list = member.getProducts();
		
		// Member가 가지고 있는 product list 조회
		for(Product product : list) {
			System.out.println(product);
		}
		
	}
	
	private static void testInverse(EntityManager em) {
		Product product = em.find(Product.class, 1L);
		List<Member> list = product.getMembers();
		
		for(Member member : list) {
			System.out.println(member);
		}
		
	}
	
	
	
}
