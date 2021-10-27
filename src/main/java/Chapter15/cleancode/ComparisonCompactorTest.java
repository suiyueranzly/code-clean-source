/**
 *
 */
package Chapter15.cleancode;

import junit.framework.TestCase;

public class ComparisonCompactorTest extends TestCase {
    public void testMessage() {

        String failure = new ComparisonCompactor(0, "b", "c").formatCompactComparison("a");
        assertTrue("a expected:<[b]> but was:<[c]>".equals(failure));
    }

    public void testStartSame() {
        String failure = new ComparisonCompactor(1, "ba", "bc").formatCompactComparison(null);
        assertEquals("expected:<b[a]> but was:<b[c]>", failure);
    }

    public void testEndSame() {

        String failure = new ComparisonCompactor(1, "ab", "cb").formatCompactComparison(null);
        assertEquals("expected:<[a]b> but was:<[c]b>", failure);
    }

    public void testsame() {
        String failure = new ComparisonCompactor(1, "ab", "ab").formatCompactComparison(null);
        assertEquals("expected:<ab> but was:<ab>", failure);
    }

    public void testNoContextstartAndEndSame() {
        String failure = new ComparisonCompactor(0, "abc", "adc").formatCompactComparison(null);
        assertEquals("expected:<...[b]...> but was:<...[d]...>", failure);
    }

    public void teststartAndEndContext() {

        String failure = new ComparisonCompactor(1, "abc", "adc").formatCompactComparison(null);
        assertEquals("expected:<a[b]c> but was:<a[d]c>", failure);
    }

    public void teststartAndEndContextwithEllipses() {

        String failure = new ComparisonCompactor(1, "abcde", "abfde").formatCompactComparison(null);
        assertEquals("expected:<...b[c]d...> but was:<...b[f]d...>", failure);
    }

    public void testcomparisonErrorStartSameComplete() {

        String failure = new ComparisonCompactor(2, "ab", "abc").formatCompactComparison(null);
        assertEquals("expected:<ab[]> but was:<ab[c]>", failure);
    }

    public void testcomparisonErrorEndSameComplete() {
        String failure = new ComparisonCompactor(0, "bc", "abc").formatCompactComparison(null);
        assertEquals("expected:<[]...> but was:<[a]...>", failure);
    }

    public void testcomparisonErrorEndSameCompleteContext() {
        String failure = new ComparisonCompactor(2, "bc", "abc").formatCompactComparison(null);
        assertEquals("expected:<[]bc> but was:<[a]bc>", failure);
    }

    public void testComparisonErroroverlapingMatches() {
        String failure = new ComparisonCompactor(0, "Abc", "abbc").formatCompactComparison(null);
        assertEquals("expected:<[A]...> but was:<[ab]...>", failure);
    }

    public void testcomparisonErrorOverlapingMatchesContext() {
        String failure = new ComparisonCompactor(2, "abc", "abbc").formatCompactComparison(null);
        assertEquals("expected:<ab[]c> but was:<ab[b]c>", failure);
    }

    public void testComparisonErroroverlapingMatches2() {
        String failure =
                new ComparisonCompactor(0, "abcdde", "abcde").formatCompactComparison(null);
        assertEquals("expected:<...[d]...> but was:<...[]...>", failure);
    }

    public void testComparisonErroroverlapingMatches2Context() {
        String failure =
                new ComparisonCompactor(2, "abcdde", "abcde").formatCompactComparison(null);
        assertEquals("expected:<...cd[d]e> but was:<...cd[]e>", failure);
    }

    public void testComparisonErrorwithActualNull() {
        String failure = new ComparisonCompactor(0, "a", "null").formatCompactComparison(null);
        assertEquals("expected:<[a]> but was:<[null]>", failure);
    }

}
