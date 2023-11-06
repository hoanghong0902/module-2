package com.codegym;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleClassifierTest {
    @Test
    public void testEquilateralTriangle(){
        TriangleClassifier triangleClassifier = new TriangleClassifier(2,2,2);
        boolean result = triangleClassifier.equilateralTriangle();
        assertTrue(result);
    }
    @Test
    public void testIsoscelesTriangle(){
        TriangleClassifier triangleClassifier = new TriangleClassifier(2,2,3);
        boolean result = triangleClassifier.isoscelesTriangle();
        assertTrue(result);
    }
    @Test
    public void testNonTriangle(){
        TriangleClassifier triangleClassifier = new TriangleClassifier(3,4,5);
        boolean result = triangleClassifier.nonTriangle();
        assertTrue(result);
    }
    @Test
    public void testNotTriangle1(){
        TriangleClassifier triangleClassifier = new TriangleClassifier(8,2,3);
        boolean result = triangleClassifier.nonTriangle();
        assertFalse(result);
    }
    @Test
    public void testNotTriangle2(){
        TriangleClassifier triangleClassifier = new TriangleClassifier(-1,2,1);
        boolean result = triangleClassifier.nonTriangle();
        assertFalse(result);
    }
    @Test
    public void testNotTriangle3(){
        TriangleClassifier triangleClassifier = new TriangleClassifier(0,1,1);
        boolean result = triangleClassifier.nonTriangle();
        assertFalse(result);
    }
}
