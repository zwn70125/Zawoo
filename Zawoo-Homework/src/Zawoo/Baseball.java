package Zawoo;

public class Baseball
{
	public static void ShowDistances()
	{
//		System.out.println(Baseball.getOppFromHyp(24.2, 60.5));
//		System.out.println(Baseball.getAdjFromHyp(24.2, 60.5)); 
//		System.out.println(Baseball.getAngle(24.8, 55.183, 60.5));
//		System.out.println(Baseball.getAngle(55.183, 60.5, 24.8));
//		System.out.println(Baseball.getAngle(60.5, 24.8, 55.183));
//		System.out.println(Baseball.getHypFromAdj(84.3, 5.7, 24.8));

	    double d1 = 0;
	    double d2 = 0;
	    double d1AngleOfDef = 29.9;
	    double d2AngleOfDef = 24.2;
	    double pitchersMoundToHomePlate = 60.5;
	    double pitchersMoundToHomePlateIntersection = 0;
	    double homePlateIntersection = 0;
	    double homePlateIntersectionAngle = 0;
	    double spectatorToHomePlateIntersection = 0;
	    
	    // to calculate d2, find triangle formed by the hypotenuse
	    // from the pitcher's mound to home plate with a height
	    // intersecting from home plate to d2;
	    // triangle P(itcher's Mound)H(ome plate)I(ntersection)
	    
	    // known side is 60.5 (hypotenuse) -- PH
	    // known angle is 24.2, the angle of deflection -- PI
	    
	    // get distance from pitcher's mound to intersection
	    pitchersMoundToHomePlateIntersection = getAdjFromHyp(d2AngleOfDef, pitchersMoundToHomePlate);
	    
	    // get height of intersection -- HI
	    homePlateIntersection = getOppFromHyp(d2AngleOfDef, pitchersMoundToHomePlate);
	    
	    // find triangle formed from spectator to intersection and
	    // spectator to home plate: triangle SHI
	    
	    // get angle from home plate to d2 intersection
	    homePlateIntersectionAngle = 180 - 90 - (d1AngleOfDef - d2AngleOfDef);
	    
	    // find d1 (home plate to spectator)
	    d1 = getHypFromAdj(homePlateIntersectionAngle, d1AngleOfDef - d2AngleOfDef, homePlateIntersection);
	    
	    // get spectator distance to home plate intersection with d2
	    spectatorToHomePlateIntersection = getAdjFromHyp(d1AngleOfDef - d2AngleOfDef, d1);
	    
	    // find d2 (pitcher's mound to spectator)
	    d2 = spectatorToHomePlateIntersection + pitchersMoundToHomePlateIntersection;
	    
	    // display results
	    System.out.println("Spectator to Home Plate (D1): " + (Math.round(d1 * 100.0) / 100.0) + "ft");
	    System.out.println("Spectator to Pitcher's Mound (D2): " + (Math.round(d2 * 100.0) / 100.0) + "ft");
	}
	
	public static double getOppFromHyp(double angle, double hypotenuse)
	{
		return hypotenuse * Math.sin(Math.toRadians(angle));
	}
	
	public static double getAdjFromHyp(double angle, double hypotenuse)
	{
		return hypotenuse * Math.cos(Math.toRadians(angle));
	}
	
	public static double getHypFromAdj(double adjacentAngle, double oppositeAngle, double adjacentLength)
	{
		return ((adjacentLength * Math.sin(Math.toRadians(adjacentAngle)) / Math.sin(Math.toRadians(oppositeAngle))));
	}
}
