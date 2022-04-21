package com.nnk.springboot.repositories;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.RuleName;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class RuleTests {
	@Autowired
	private RuleNameRepository ruleNameRepository;


	@Test
	public void ruleTest() {
		RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");

		// Save
		rule = ruleNameRepository.save(rule);
		assertNotNull(rule.getId());
		assertTrue(rule.getName().equals("Rule Name"));
		assertTrue(rule.getDescription().equals("Description"));
		assertTrue(rule.getSqlPart().equals("SQL Part"));
		assertTrue(rule.getSqlStr().equals("SQL"));
		assertTrue(rule.getTemplate().equals("Template"));
		assertTrue(rule.getJson().equals("Json"));
		// Update
		rule.setName("Rule Name Update");
		rule.setDescription("description");
		rule.setJson("json");
		rule.setSqlPart("sqlPart");
		rule.setSqlStr("sqlStr");
		rule.setTemplate("template");

		rule = ruleNameRepository.save(rule);
		assertTrue(rule.getName().equals("Rule Name Update"));
		assertTrue(rule.getDescription().equals("description"));
		assertTrue(rule.getSqlPart().equals("sqlPart"));
		assertTrue(rule.getSqlStr().equals("sqlStr"));
		assertTrue(rule.getTemplate().equals("template"));
		assertTrue(rule.getJson().equals("json"));

		// Find
		List<RuleName> listResult = ruleNameRepository.findAll();
		assertTrue(listResult.size() > 0);

//		// Delete
//		Integer id = rule.getId();
//		ruleNameRepository.delete(rule);
//		Optional<RuleName> ruleList = ruleNameRepository.findById(id);
//		assertFalse(ruleList.isPresent());
	}
}
