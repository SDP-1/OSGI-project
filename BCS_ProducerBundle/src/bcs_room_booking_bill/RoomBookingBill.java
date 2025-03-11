package bcs_room_booking_bill;


public class RoomBookingBill {
	public int billId;
	
	public int roomId;
	public String RoomType;
	public int dates;
	
	public double descount;
	public double TotalPricce;
	
	@Override
	public String toString() {
	    return "RoomBookingBill{" +
	            "billId=" + billId +
	            ", roomId=" + roomId +
	            ", RoomType='" + RoomType + '\'' +
	            ", dates=" + dates +
	            ", descount=" + descount +
	            ", TotalPricce=" + TotalPricce +
	            '}';
	}

}
