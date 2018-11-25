import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ShortestPathAlgorithm implements IAlgorithm {

	@Override
    public ICar findBestCar(List<ICar> lstCars, Direction direction, int destinationFloorNumber) {
        // TODO Auto-generated method stub
        ICar currentCar = null;
        
        if(lstCars.size() ==1){currentCar = lstCars.get(0);
            return currentCar;}
        
        lstCars =partitionCars(lstCars,destinationFloorNumber);
        
        System.out.println("hellll no biatch 44449439409439");
        
        for(int i=0; i< lstCars.size(); i++){
            
            ICar car = lstCars.get(i);
            if((direction == Direction.UP) & ((car.getStatus() == CarStatus.MOVING_UP) || ((car.getStatus() == CarStatus.STOPPED))) & (car.getCurrentFloorNumber() <= destinationFloorNumber ) ) {
                currentCar = lstCars.get(i);
                break;
            }else if((direction == Direction.DOWN) & ((car.getStatus() == CarStatus.MOVING_DOWN) || ((car.getStatus() == CarStatus.STOPPED) )) & (car.getCurrentFloorNumber() >= destinationFloorNumber ) ) {
                currentCar = lstCars.get(i);System.out.println("hellll no biatch 44449439409439");
                break;
            }else if(car.getStatus() == CarStatus.IDLE)
            {	currentCar = lstCars.get(i);System.out.println("hellll no biatch 44449439409439");
            }
        }
        if(currentCar == null){
            Random random = new Random();
            
            int randomnumber = random.nextInt(lstCars.size());
            
            currentCar = lstCars.get(randomnumber);System.out.println("hellll no biatch 44449439409439");
        }
        System.out.println("hellll no biatch 44449439409439");
        // TODO Auto-generated method stub
        return currentCar;
    }
    
    
    //}
    private List<ICar> partitionCars(List<ICar> lstCars, int destinationFloorNumber) {
        
        ArrayList<ICar> oddCars=new ArrayList<ICar>();
        ArrayList<ICar> evenCars=new ArrayList<ICar>();
        
        for(int i=0;i<lstCars.size();i++){
            ICar car1=lstCars.get(i);
            
            IUserPanel us=car1.getUserPanel();
            if(us.getSelection()==1)
                evenCars.add(car1);
            else if(us.getSelection()==2)
                oddCars.add(car1);
            else{
                oddCars.add(car1);
                evenCars.add(car1);
            }
            
            
        }
        
        if (destinationFloorNumber%2==0)
            return evenCars;
        else
            
            return oddCars;
        
    }
    
}