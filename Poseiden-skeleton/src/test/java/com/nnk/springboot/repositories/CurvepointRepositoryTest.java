package com.nnk.springboot.repositories;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.CurvePoint;

@SpringBootTest
public class CurvepointRepositoryTest {
	@Autowired
	private CurvePointRepository curvePointRepository;
	
	@Test
	public void curvePointTest() {
		CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);

		// Save

		curvePoint = curvePointRepository.save(curvePoint);

		assertNotNull(curvePoint.getId());
		assertTrue(curvePoint.getCurveId() == 10);
		assertTrue(curvePoint.getTerm() == 10d);
		assertTrue(curvePoint.getValue() == 30d);

		// Update

		curvePoint.setCurveId(20);
		curvePoint.setTerm(20d);
		curvePoint.setValue(100d);
		curvePoint = curvePointRepository.save(curvePoint);
		assertTrue(curvePoint.getCurveId() == 20);
		assertTrue(curvePoint.getTerm() == 20d);
		assertTrue(curvePoint.getValue() == 100d);

		// Find

		List<CurvePoint> listResult = curvePointRepository.findAll();
		assertTrue(listResult.size() > 0);

		// Delete

//		Integer id = curvePoint.getId();
//		curvePointRepository.delete(curvePoint);
//		Optional<CurvePoint> curvePointList = curvePointRepository.findById(id);
//		assertFalse(curvePointList.isPresent());

	}

}
