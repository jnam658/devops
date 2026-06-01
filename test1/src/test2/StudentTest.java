package test2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentTest {
	static Student std;
	@BeforeAll
	static void setUp() throws Exception {
		std = new Student();
	}

	@Test
	@Order(1)
	void testAddStudent() {
		std.addStudent("홍길동");
        assertTrue(std.hasStudent("홍길동"));
	}
	
	@Test
	@Order(2)
	void testStudentAlreadyExist() {
		assertThrows(
		        IllegalArgumentException.class,
		        () -> std.addStudent("홍길동")
		    );
	}

	@Test
	@Order(3)
	void testRemoveStudent() {
		std.removeStudent("홍길동");
		assertFalse(std.hasStudent("홍길동"));
	}
	
	@Test
	@Order(4)
	void testDeleteInvaidStudent() {
		assertThrows(
				IllegalArgumentException.class,
				()-> std.removeStudent("홍길동")
			);
	}
	
	@Test
	@Order(5)
	void testAddDeletedStudent() {
		std.addStudent("홍길동");
		assertTrue(std.hasStudent("홍길동"));
	}
	
	@Test
	@Order(6)
	void testFailCase() {
		assertTrue(std.hasStudent("가나다"));
	}

}
