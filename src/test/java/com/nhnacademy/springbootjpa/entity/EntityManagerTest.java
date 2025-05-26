package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EntityManagerTest {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO #1: 다음 테스트를 실행하면 수행될 쿼리는?
    // 없음
    @Test
    void test1() {
        // 비영속 상태
        User user1 = new User("newUser", "abcde");

        // 영속 상태
        entityManager.persist(user1);

        // 캐시(세션)에서 바로 반환 (DB 접근X)
        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);
    }

    // TODO #2: 다음 테스트를 실행하면 수행될 쿼리는?
    // INSERT 1회 -> SELECT 발생 x
    @Test
    void test2() {
        // 비영속 상태
        User user1 = new User("newUser", "abcde");

        // 영속 상태(1차 캐시에 존재)
        entityManager.persist(user1);
        // DB에 실질적인 쿼리 발생 (영속성 컨텍스트에 있는 newUser에 대해 Insert쿼리 발생)
        // But -> newUser는 영속성 컨텍스트에 남아있음
        // DB에도 데이터가 저장됐을 뿐, 자바 객체의 영속 상태가 변한건 아님
        entityManager.flush();          // <--

        // JPA -> 항시 1차 캐시를 먼저 확인
        // 만약 PK(newUser)에 해당하는 엔티틸가 1차 캐시(영속상태)에 있다면
        // DB에 접근하지 않고 메모리에 있던 객체를 반환
        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);
    }

    // TODO #3: 다음 테스트를 실행하면 수행될 쿼리는?
    // UPDATE 쿼리만 발생
    @Test
    void test3() {
        // 비영속 상태
        User user1 = new User("newUser", "abcde");

        // 영속 상태 (1차 캐시에 존재)
        entityManager.persist(user1);

        // test1과 같이 1차캐시에 존재하는 엔터티 바로 반환
        User user2 = entityManager.find(User.class, "newUser");

        // 두 객체의 참조값 일치 확인 -> 일치
        assertThat(user2).isEqualTo(user1);

        // 영속상태에 있는 객체를 가져와 업데이트
        user2.setPassword("fghij");
        // 실질적 UPDATE문 쿼리
        entityManager.flush();
    }

    // TODO #4: 다음 테스트를 실행하면 수행될 쿼리는?
    // SELECT 쿼리 1회 발생
    @Sql("entity-manager-test.sql")
    @Test
    void test4() {
        // 영속성 컨텍스트(1차 캐시)에 존재하지 않기 때문에
        // DB에 실질적인 SELECT쿼리를 한번 보냄 (이떄 자동으로 영속상태로 변경)
        User user1 = entityManager.find(User.class, "admin");
        // 이후부터 영속상태에 admin이라는 엔터티가 존재하니
        // 실질적인 쿼리 발생은 SELECT1회
        User user2 = entityManager.find(User.class, "admin");
        User user3 = entityManager.find(User.class, "admin");
        User user4 = entityManager.find(User.class, "admin");
        User user5 = entityManager.find(User.class, "admin");

        assertThat(user1).isEqualTo(user2);
        assertThat(user1).isEqualTo(user3);
        assertThat(user1).isEqualTo(user4);
        assertThat(user1).isEqualTo(user5);
    }

}
