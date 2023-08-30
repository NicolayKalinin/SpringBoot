@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	@BeforeAll
	public static void setUp() {

	}

	@Test
	void contextLoads() {
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + myapp.getMappedPort(8080), String.class);
		System.out.println(forEntity.getBody());
	}

}