package org.jfree.data;

import static org.junit.Assert.*; import org.junit.*;

public class RangeTest {
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range exampleRange5;
    private Range exampleRange6;
    private Range nullRange1;
    private Range nullRange2;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    // Initialize several ranges to use for testing
    @Before
    public void setUp() throws Exception { 
        exampleRange1 = new Range(-3, 3);
        exampleRange2 = new Range(-20, -10);
        exampleRange3 = new Range(5, 9);
        exampleRange4 = new Range(-15, 0); 
        exampleRange5 = new Range(-15, -5); 
        exampleRange6 = new Range(-5, 0); 
    }

    // Contains Method
    // This test covers a value below the lower boundary of the range
    // in the contains method
    @Test
    public void test_contains_belowLowerBoundary() {
        assertFalse("False should be returned for -4 in range -3 to 3.",
        exampleRange1.contains(-4));
    }

    // This test covers a value on the lower boundary of the range
    // in the contains method
    @Test
    public void test_contains_onLowerBoundary() {
        assertTrue("True should be returned for -3 in range -3 to 3.",
        exampleRange1.contains(-3));
    }
    
    // This test covers a value within the range and very near
    // the lower boundary of the range in the contains method
    @Test
    public void test_contains_nearLowerBoundary() {
        assertTrue("True should be returned for -2.9 in range -3 to 3.",
        exampleRange1.contains(-2.9));
    }

    // This test covers a value within the range and very near
    // the upper boundary of the range in the contains method
    @Test
    public void test_contains_nearUpperBoundary() {
        assertTrue("True should be returned for 2.9 in range -3 to 3.",
        exampleRange1.contains(2.9));
    }

    // This test covers a value on the upper boundary of the range
    // in the contains method
    @Test
    public void test_contains_onUpperBoundary() {
        assertTrue("True should be returned for 3 in range -3 to 3.",
        exampleRange1.contains(3));
    }

    // This test covers a value above the upper boundary of the range
    // in the contains method
    // Modified test value from 9 to 4 so it is nearer the range and 
    // will kill mutation where the argument is decremented
    @Test
    public void test_contains_aboveUpperBoundary() {
        assertFalse("False should be returned for 4 in range -3 to 3.",
        exampleRange1.contains(4));
    }

    // getLength Method
    // This test covers a range with two negative bounds
    // in the getLength method
    @Test
    public void test_getLength_bothNegative() {
        assertEquals("The length of range -20 to -10 should be 11", 10,
        exampleRange2.getLength(), .000000001d);
    }

    // This test covers a range with one negative and one
    // positive bound in the getLength method
    @Test
    public void test_getLength_NegativeAndPositive() {
        assertEquals("The length of range -3 to 3 should be 7", 6,
        exampleRange1.getLength(), .000000001d);
    }

    // This test covers a range with two positive bounds
    // in the getLength method
    @Test
    public void test_getLength_bothPositive() {
        assertEquals("The length of range 5 to 9 should be 5", 4,
        exampleRange3.getLength(), .000000001d);
    }
    
    // getLowerBound
    // This test covers a range with a positive lower bound
    // in the getLength method
    @Test
    public void test_getLowerBound_Positive() {
        assertEquals("The lower bound should be 5", 5,
        exampleRange3.getLowerBound(), .000000001d);
    }

    // This test covers a range with a negative lower bound
    // in the getLength method
    @Test
    public void test_getLowerBound_Negative() {
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
    }
    
    // intersects Method
    // Added check to ensure range values do not change
    
    // This test covers two ranges that overlap on the upper bound
    // in the intersects method
    @Test
    public void test_intersects_upperBoundOverlap() {
        assertTrue("True should be returned for ranges -3 to 3 and 1 to 10 overlapping",
        exampleRange1.intersects(1, 10));
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
        assertEquals("The upper bound should be 3", 3,
        exampleRange1.getUpperBound(), .000000001d);
    }

    // This test covers two ranges that overlap on the lower bound
    // in the intersects method
    @Test
    public void test_intersects_lowerBoundOverlap() {
        assertTrue("True should be returned for ranges -3 to 3 and -5 to -2 overlapping",
        exampleRange1.intersects(-5, -2));
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
        assertEquals("The upper bound should be 3", 3,
        exampleRange1.getUpperBound(), .000000001d);
    }

    // This test covers two ranges where the range that calls the method
    // is completely contained the range provided by the arguments
    // in the intersects method
    @Test
    public void test_intersects_rangeOneCompletelyContainedOverlap() {
        assertTrue("True should be returned for ranges -3 to 3 and -5 to 19 overlapping",
        exampleRange1.intersects(-5, 10));
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
        assertEquals("The upper bound should be 3", 3,
        exampleRange1.getUpperBound(), .000000001d);
    }

    // This test covers two ranges where the range provided by the arguments
    // is completely contained within the range that calls the intersects method
    @Test
    public void test_intersects_rangeTwoCompletelyContainedOverlap() {
        assertTrue("True should be returned for ranges -3 to 3 and -1 to 1 overlapping",
        exampleRange1.intersects(-1, 1));
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
        assertEquals("The upper bound should be 3", 3,
        exampleRange1.getUpperBound(), .000000001d);
    }
    
    // Note: Modified source code for intersects method to fix when intersecting bounds
    // are equal
    
    // This test covers two ranges that connect on the lower bound
    // without overlapping in the intersects method
    @Test
    public void test_intersects_rangeOnLowerBound() {
        assertTrue("True should be returned for ranges -3 to 3 and -10 to -3 overlapping",
        exampleRange1.intersects(-10, -3));
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
        assertEquals("The upper bound should be 3", 3,
        exampleRange1.getUpperBound(), .000000001d);
    }
    
    // This test covers two ranges that connect on the upper bound
    // without overlapping in the intersects method
    @Test
    public void test_intersects_rangeOnUpperBound() {
        assertTrue("True should be returned for ranges -3 to 3 and 3 to 11 overlapping",
        exampleRange1.intersects(3, 11));
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
        assertEquals("The upper bound should be 3", 3,
        exampleRange1.getUpperBound(), .000000001d);
    }
    
    // This test covers two ranges that do not intersect where the range provided
    // by the arguments is below the range that calls the intersects method
    @Test
    public void test_intersects_rangeBelowLowerBound() {
        assertFalse("False should be returned for ranges -3 to 3 and -10 to -5 overlapping",
        exampleRange1.intersects(-10, -5));
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
        assertEquals("The upper bound should be 3", 3,
        exampleRange1.getUpperBound(), .000000001d);
    }

    // This test covers two ranges that do not intersect where the range provided
    // by the arguments is above the range that calls the intersects method
    @Test
    public void test_intersects_rangeAboveUpperBound() {
        assertFalse("False should be returned for ranges -3 to 3 and 20 to 22 overlapping",
        exampleRange1.intersects(20, 22));
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
        assertEquals("The upper bound should be 3", 3,
        exampleRange1.getUpperBound(), .000000001d);
    }
    
    // Combine
    // This test covers combining two ranges that overlap
    @Test
    public void test_combine_rangesOverlap() {
    	Range newRange = Range.combine(exampleRange4, exampleRange2);
    	assertEquals("The new lower bound should be -20", -20,
    	newRange.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 0", 0,
    	newRange.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges that do not overlap
    @Test
    public void test_combine_rangesNoOverlap() {
    	Range newRange = Range.combine(exampleRange2, exampleRange1);
    	assertEquals("The new lower bound should be -20", -20,
    	newRange.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 3", 3,
    	newRange.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges where one range
    // is contained with in the other
    @Test
    public void test_combine_rangesContainedWithin() {
    	Range newRange = Range.combine(exampleRange2, new Range(-17, -15));
    	assertEquals("The new lower bound should be -20", -20,
    	newRange.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be -10", -10,
    	newRange.getUpperBound(), .000000001d);
    }

    // This test covers combining two ranges where
    // first range is null
    @Test
    public void test_combine_firstRangeNull() {
    	Range newRange = Range.combine(nullRange1, exampleRange2);
    	assertEquals("The new lower bound should be -20", -20,
    			newRange.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be -10", -10,
    			newRange.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges where
    // second range is null
    @Test
    public void test_combine_secondRangeNull() {
        Range newRange = Range.combine(exampleRange1, nullRange1);
        assertEquals("The new lower bound should be -3", -3,
        newRange.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 3", 3,
        newRange.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges where
    // both ranges are null
    @Test
    public void test_combine_bothRangeNull() {
        assertNull("The new range should be null", 
        Range.combine(nullRange1, nullRange2));
    }
    
    
    // This test covers the intersect method with a Range
    // object as the argument when the two intersect
    @Test
    public void test_intersects_object_positive() {
    	assertTrue("True should be returned for ranges -20 to 10 and -15 to 0 overlapping",
    	exampleRange2.intersects(exampleRange4));
    }
    
    // This test covers the intersect method with a Range
    // object as the argument when the two do not intersect
    @Test
    public void test_intersects_object_negative() {
    	assertFalse("False should be returned for ranges -3 to 3 and -20 to -10 overlapping",
    	exampleRange1.intersects(exampleRange2));
    }
    
    // getCentralValue Method
    // This test covers a range with one negative bound
    // and one positive bound in the getCentralValue method
    // Added check to ensure that the Range bounds do not change for Mutation testing
    @Test
    public void test_getCentralValue() {
    	assertEquals("The central value should be -15", -15,
    	exampleRange2.getCentralValue(), .000000001d);
    	assertEquals("The lower bound should be -20", -20,
    	exampleRange2.getLowerBound(), .000000001d);
    	assertEquals("The upper bound should be -10", -10,
    	exampleRange2.getUpperBound(), .000000001d);
    }
    
    // constrain Method
    // This test covers a value that is below a range
    // Modified test value from -5 to -4
    @Test
    public void test_constrain_below() {
    	assertEquals("The value within the range closest to -4 should be -3", -3,
    			exampleRange1.constrain(-4), .000000001d);
    }
    
    // This test covers a value that is on the lower boundary
    @Test
    public void test_constrain_on_lower() {
    	assertEquals("The value within the range closest to -3 should be -3", -3,
    			exampleRange1.constrain(-3), .000000001d);
    }
    
    // This test covers a value that is contained within a range
    // Modified the range from (-3, 3) to (-20, -10) so it is not symmetrical
    // to kill mutants that negate the value
    @Test
    public void test_constrain_within_range() {
    	assertEquals("The value within the range closest to -15 should be -15", -15,
    	exampleRange2.constrain(-15), .000000001d);
    }
    
    // This test covers a value that is on the upper boundary
    @Test
    public void test_constrain_on_upper() {
    	assertEquals("The value within the range closest to 3 should be 3", 3,
    			exampleRange1.constrain(3), .000000001d);
    }
    
    // This test covers a value that is above a range
 // Modified test value from 5 to 4
    @Test
    public void test_constrain_above() {
    	assertEquals("The value within the range closest to 4 should be 3", 3,
    	exampleRange1.constrain(4), .000000001d);
    }
    
    // equals Method
    // This test covers an invalid argument passed to the equals method. 
    // A double is passed as argument instead of a Range object
    @Test
    public void test_equals_invalid_object() {
    	assertFalse("False should be returned for invalid argument passed in",
    	exampleRange1.equals(5));
    }
    
    // This test covers a valid argument where upper range does not match
    @Test
    public void test_equals_upper_incorrect() {
    	assertFalse("False should be returned because ranges don't equal",
    	exampleRange4.equals(exampleRange5));
    }

    // This test covers a valid argument where lower range does not match
    @Test
    public void test_equals_lower_incorrect() {
    	assertFalse("False should be returned because ranges don't equal",
    	exampleRange4.equals(exampleRange6));
    }
    
    // This test covers a valid argument where ranges match
    @Test
    public void test_equals_positive() {
    	Range range = exampleRange1;
    	assertTrue("True should be returned because ranges match",
    	exampleRange1.equals(range));
    }
    
    @Test
    public void test_equals_null() {
    	Range range = new Range(-3.0, 3.0);
        assertFalse("equals should return false when comparing to null", range.equals(null));
    }
    
    // scale Method
    // This test covers scaling with a positive factor
    @Test
    public void test_scale_positive_factor() {
        double factor = 2;
        Range result = Range.scale(exampleRange1, factor);
        assertEquals("The new lower bound should be -6", -6, result.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 6", 6, result.getUpperBound(), .000000001d);
    }

    // This test covers scaling with a factor of zero
    @Test
    public void test_scale_zero_factor() {
        double factor = 0;
        Range result = Range.scale(exampleRange1, factor);
        assertEquals("The new lower bound should be 0", 0, result.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 0", 0, result.getUpperBound(), .000000001d);
    }

    // This test covers the IllegalArgumentException when a negative number is the factor
    @Test(expected = IllegalArgumentException.class)
    public void test_scale_negative_factor() {
        double factor = -2;
        Range.scale(exampleRange1, factor);
    }
    
    // This test covers the IllegalArgumentException when a null range is used
    @Test(expected = IllegalArgumentException.class)
    public void test_scale_null_range() {
        double factor = 1;
        Range.scale(nullRange1, factor);
    }
    
    // isNaNRange method
    // This test covers where both numbers are NaN in a Range
    @Test
    public void test_isNaNRange_both_NaN() {
    	Range NaNRange = new Range(Double.NaN, Double.NaN);
    	assertTrue("True should be returned because Range bounds are NaN",
    	NaNRange.isNaNRange());
    }
    
    // This test covers where both numbers valid doubles in a Range
    @Test
    public void test_isNaNRange_neither_NaN() {
    	assertFalse("False should be returned becauase Range bounds are valid",
    	exampleRange1.isNaNRange());
    }
    
    @Test
    public void testIsNaNRangeWithOnlyNaNUpper() {
        Range range = new Range(0.0, Double.NaN);
        assertFalse("isNaNRange should return false when lower bound is non-NaN and upper bound     is NaN", range.isNaNRange());
    }
    
    @Test
    public void testIsNaNRangeWithOnlyNaNLower() {
        Range range = new Range(Double.NaN, 10.0);
        assertFalse("isNaNRange should return false when upper bound is non-NaN and lower bound is NaN", range.isNaNRange());
    }
    
    // This test covers hashCode method with to check if two equal ranges
    // provide equal hash codes
    @Test
    public void test_hashCode_equal_ranges() {
    	assertEquals(exampleRange1.hashCode(), exampleRange1.hashCode());
    }
    
    @Test
    public void test_hashCode_different_ranges() {
    	Range differentRange = new Range(0.0, 5.0);
    	assertNotEquals("Hash codes should not be equal for different ranges", exampleRange1.hashCode(), differentRange.hashCode());
    }
    
    @Test
    public void testHashCodeAfterNegatingLower() {
        Range modifiedRange = new Range(-exampleRange1.getLowerBound(), exampleRange1.getUpperBound());
        assertNotEquals("Hash code should not match after negating lower field", exampleRange1.hashCode(), modifiedRange.hashCode());
    }

    @Test
    public void testHashCodeAfterIncrementingLower() {
        Range modifiedRange = new Range(exampleRange1.getLowerBound() + 1, exampleRange1.getUpperBound());
        assertNotEquals("Hash code should not match after incrementing lower field", exampleRange1.hashCode(), modifiedRange.hashCode());
    }

    @Test
    public void testHashCodeAfterDecrementingLower() {
        Range modifiedRange = new Range(exampleRange1.getLowerBound() - 1, exampleRange1.getUpperBound());
        assertNotEquals("Hash code should not match after decrementing lower field", exampleRange1.hashCode(), modifiedRange.hashCode());
    }

    @Test
    public void testHashCodeAfterIncrementingUpper() {
        Range modifiedRange = new Range(exampleRange1.getLowerBound(), exampleRange1.getUpperBound() + 1);
        assertNotEquals("Hash code should not match after incrementing upper field", exampleRange1.hashCode(), modifiedRange.hashCode());
    }

    @Test
    public void testHashCodeAfterNegatingUpper() {
        Range modifiedRange = new Range(exampleRange1.getLowerBound(), -exampleRange1.getUpperBound());
        assertNotEquals("Hash code should not match after negating upper field", exampleRange1.hashCode(), modifiedRange.hashCode());
        assertEquals("Lower bound should be -3.0", -3.0, exampleRange1.getLowerBound(), 0.0);
        assertEquals("Upper bound should be 3.0", 3.0, exampleRange1.getUpperBound(), 0.0);
    }
    // This test covers the toString method
    @Test
    public void test_toString() {
        String expectedString = "Range[-3.0,3.0]";
        String actualString = exampleRange1.toString();
        assertEquals("The string should be " + expectedString, expectedString, actualString);
    }
    
    // shift Method
    // This test covers the shift method without the boolean argument
    @Test
    public void test_shift_no_bool() {
    	Range result = Range.shift(exampleRange1, 2);
    	assertEquals("The new lower bound should be -1", -1, result.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 5", 5, result.getUpperBound(), .000000001d);
    }
    
    // This test covers the shift method with the boolean argument to not allow zero crossing
    // with values that do not cross zero anyways
    @Test
    public void test_shift_no_zero_cossing1() {
    	Range result = Range.shift(exampleRange1, 2, false);
    	assertEquals("The new lower bound should be -1", -1, result.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 5", 5, result.getUpperBound(), .000000001d);
    }
    
    // This test covers the shift method with the boolean argument to not allow zero crossing
    // with values that would cross zero
    @Test
    public void test_shift_no_zero_cossing2() {
    	Range result = Range.shift(exampleRange1, 4, false);
    	assertEquals("The new lower bound should be 0", 0, result.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 7", 7, result.getUpperBound(), .000000001d);
    }
    
    // This test covers the shift method with the boolean argument to not allow zero crossing
    // with delta value of 0
    @Test
    public void test_shift_no_zero_bound_equals_zero() {
    	Range result = Range.shift(exampleRange6, 2, false);
    	assertEquals("The new lower bound should be -3", -3, result.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 2", 2, result.getUpperBound(), .000000001d);
    }
    
    // This test covers the shift method with the boolean argument to allow zero crossing
    @Test
    public void test_shift_with_zero_crossing() {
    	Range result = Range.shift(exampleRange1, 4, true);
    	assertEquals("The new lower bound should be 1", 1, result.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 7", 7, result.getUpperBound(), .000000001d);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testShiftWithNullBase() {
        Range result = Range.shift(null, 2.0, false);
    }
    
    @Test
    public void testShiftWithNegativeDelta() {
        Range base = new Range(-3.0, 3.0);
        Range result = Range.shift(base, -2.0, true);
        assertEquals("Lower bound should shift with negative delta", -5.0, result.getLowerBound(), 0.0);
        assertEquals("Upper bound should shift with negative delta", 1.0, result.getUpperBound(), 0.0);
    }
    
    @Test
    public void testShiftWithZeroDelta() {
        Range base = new Range(-3.0, 3.0);
        Range result = Range.shift(base, 0.0, true);
        assertEquals("Lower bound should not shift with zero delta", -3.0, result.getLowerBound(), 0.0);
        assertEquals("Upper bound should not shift with zero delta", 3.0, result.getUpperBound(), 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalArgumentException() {
        double lower = 10.0;
        double upper = 5.0;
        new Range(lower, upper);
    }

    // combineIgnoringNaN method
    // This test covers combining two ranges where both ranges are valid
    @Test
    public void test_combineIgnoringNaN_valid() {
    	Range newRange = Range.combineIgnoringNaN(exampleRange4, exampleRange2);
    	assertEquals("The new lower bound should be -20", -20, newRange.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 0", 0, newRange.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges where both ranges are NaN
    @Test
    public void test_combineIgnoringNaN_both_NaN() {
    	Range range1 = new Range(Double.NaN, Double.NaN);
    	Range range2 = new Range(Double.NaN, Double.NaN);
    	Range result = Range.combineIgnoringNaN(range1, range2);
    	assertNull("The new range should be null", result);
    }
    
    // This test covers combining two ranges where range1 is null and range2 is NaN
    @Test
    public void test_combineIgnoringNaN_null_and_NaN() {
    	Range range2 = new Range(Double.NaN, Double.NaN);
    	Range result = Range.combineIgnoringNaN(nullRange1, range2);
    	assertNull("The new range should be null", result);
    }
    
    // This test covers combining two ranges where range1 is null and range2 is valid
    @Test
    public void test_combineIgnoringNaN_null_and_valid() {
    	Range result = Range.combineIgnoringNaN(nullRange1, exampleRange1);
    	assertEquals("The new lower bound should be -3", -3, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 3", 3, result.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges where range1 is NaN and range2 is null
    @Test
    public void test_combineIgnoringNaN_NaN_and_null() {
    	Range range1 = new Range(Double.NaN, Double.NaN);
    	Range result = Range.combineIgnoringNaN(range1, nullRange1);
    	assertNull("The new range should be null", result);
    }
    
    // This test covers combining two ranges where range1 is valid and range2 is null
    @Test
    public void test_combineIgnoringNaN_valid_and_null() {
    	Range result = Range.combineIgnoringNaN(exampleRange1, nullRange1);
    	assertEquals("The new lower bound should be -3", -3, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 3", 3, result.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges where they are both valid
    @Test
    public void test_combineIgnoringNaN_both_valid() {
    	Range result = Range.combineIgnoringNaN(exampleRange2, exampleRange5);
    	assertEquals("The new lower bound should be -20", -20, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be -5", -5, result.getUpperBound(), .000000001d);
    }
    
    // expand Method
    // This test covers expanding a range with positive lower and upper margins
    @Test
    public void test_expand_positive_margins() {
    	Range result = Range.expand(exampleRange1, 0.25, 0.25);
    	assertEquals("The new lower bound should be -4.5", -4.5, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 4.5", 4.5, result.getUpperBound(), .000000001d);
    }
    
    // This test covers expanding a range with negative lower margin and positive
    // upper margin to make the lower value higher than the upper
    @Test
    public void test_expand_negative_lower() {
    	Range result = Range.expand(exampleRange6, -2, 0);
    	assertEquals("The new lower bound should be 2.5", 2.5, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 2.5", 2.5, result.getUpperBound(), .000000001d);
    }
    
    // This test covers expanding a range where both margins are 0
    @Test
    public void test_expand_both_zero() {
    	Range result = Range.expand(exampleRange2, 0, 0);
    	assertEquals("The new lower bound should be -20", -20, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be -10", -10, result.getUpperBound(), .000000001d);
    }
    
    // This test covers expanding a null range where an exception should be thrown
    @Test(expected = IllegalArgumentException.class)
    public void test_expand_null_range() {
    	Range result = Range.expand(nullRange1, 1, 1);
    }
    
    // expandToInclude Method
    // This test covers expanding a null range
    @Test
    public void test_expandToInclude_null_range() {
    	Range result = Range.expandToInclude(nullRange1, 5);
    	assertEquals("The new lower bound should be 5", 5, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 5", 5, result.getUpperBound(), .000000001d);
    }
    
    // This test covers expanding a range with a value below the lower bound
    @Test
    public void test_expandToInclude_below() {
    	Range result = Range.expandToInclude(exampleRange1, -5);
    	assertEquals("The new lower bound should be -5", -5, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 3", 3, result.getUpperBound(), .000000001d);
    }
    
    // This test covers expanding a range with a value above the upper bound
    @Test
    public void test_expandToInclude_upper() {
    	Range result = Range.expandToInclude(exampleRange1, 5);
    	assertEquals("The new lower bound should be -3", -3, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 5", 5, result.getUpperBound(), .000000001d);
    }
    
    // This test covers expanding a range with a value within the range
    @Test
    public void test_expandToInclude_within() {
    	Range result = Range.expandToInclude(exampleRange1, 0);
    	assertEquals("The new lower bound should be -3", -3, result.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 3", 3, result.getUpperBound(), .000000001d);
    }
    
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}