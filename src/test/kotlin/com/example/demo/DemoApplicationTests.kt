package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests(@Autowired val restTemplate: TestRestTemplate) {
	@Test
	fun `Assert blog page title, content and status code`() {
		restTemplate.getForEntity<String>("/").run {
			assertThat(statusCode).isEqualTo(HttpStatus.OK)
			assertThat(body).contains("Blog</h1>")
		}
	}

	@Test
	fun `Assert greeting page name`() {
		restTemplate.getForEntity<String>("/hello?name=marino").run {
			assertThat(body).contains("Hello marino! Your age is 0.")
		}
	}
}
