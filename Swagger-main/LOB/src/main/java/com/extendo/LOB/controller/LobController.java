package com.extendo.LOB.controller;

import com.extendo.LOB.ErrorResponse.CustomExceptionHandler;
import com.extendo.LOB.ErrorResponse.ErrorHandler;
import com.extendo.LOB.ErrorResponse.ErrorResponse;
import com.extendo.LOB.ErrorResponse.RecordNotFoundException;
import com.extendo.LOB.entity.Lob;
import com.extendo.LOB.repository.LobRepository;
import com.extendo.LOB.response.ResponseHandler;
import com.extendo.LOB.service.LobService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LobController {
    @Autowired
    private LobService service;

    public LobController(LobService service, LobRepository lobRepository){

        this.service = service;
    }
    @PostMapping("/addLob")
    public ResponseEntity<Object> Post(@RequestBody Lob lob){
        try{
           Lob result = service.saveLob(lob);
           return ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK,result);
        }catch (Exception e){
           // return new ResponseEntity<Lob>(lob,HttpStatus.OK);
            //public ResponseEntity<Object> addLob (@RequestBody Lob lob){
            // Lob result = service.saveLob(lob);
            //  return new ResponseEntity<Object>(lob,HttpStatus.OK);
            //  }
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
   // @PostMapping("/addLob")
   //public ResponseEntity<Object> addLob (@RequestBody Lob lob){
       // Lob result = service.saveLob(lob);
      //  return new ResponseEntity<Object>(lob,HttpStatus.OK);
  //  }
   // public Lob addLob(@RequestBody Lob lob){
    //    return service.saveLob(lob);
   // }
  //  @PostMapping("/addLobs")
   // public List<Lob> addLobs(@RequestBody List<Lob> lobs){
   //     return service.saveLobs(lobs);
  //  }
    @GetMapping("/Lobs")
    public ResponseEntity<Object> Get(){
        try {
            List<Lob> result = (List<Lob>) service.getLobs();
            if(result==null){
                throw new RecordNotFoundException("Record_Not_Found");
            }
            return  ResponseHandler.generateResponse("Successfully retrieved Data!",HttpStatus.OK,result);
        }catch(Exception e){

            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
      //  Lob lob = Lob.getLobBylobCode(lobCode);
        //if(Lob == null){
       //     throw new RecordNotFoundException("Invalid lobCode :"+lobCode);
       //     return new ResponseEntity<Object>(lob,HttpStatus.OK);
      //  }
    }
   // public List<Lob> findAllLobs(){
   //     return service.getLobs();
   // }
    @GetMapping("/Lobs/{lobCode}")
   // public ResponseEntity<?> getLob(@PathVariable String lobCode){
     //   Lob lob = LobService.getLob(lobCode);
       // if (lobCode == null){
         //   throw new NoRecordFoundException();
       // }
        //return new ResponseEntity<>(lob,HttpStatus.OK);
    //}
    public ResponseEntity<Object> Get(@PathVariable String lobCode) {
try{
    Lob result =  this.service.getLobByLOBCode(lobCode);
    if(result==null){
        throw new RecordNotFoundException("Record_Not_Found");
    }
    return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
}catch(RecordNotFoundException e){
    return ErrorHandler.ErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST);
    //return CustomExceptionHandler.handleUserNotFoundException(e,HttpStatus.NOT_FOUND);
}
            //Lob result =  this.service.getLobByLOBCode(lobCode);
            //if(lobCode.equals(null))
           // throw new RecordNotFoundException("Record_Not_Found");
           // return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);

        //try {
          //  Lob result =  this.service.getLobByLOBCode(lobCode);
            //return ResponseHandler.handleAllExceptions("Data Not Found!",HttpStatus.OK,result);
        //}catch (Exception e){
          //  return  ResponseHandler.ErrorResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        //}
    }
   // public Lob findLobByLobCode(@PathVariable String lobCode){
     //   return this.service.getLobByLOBCode(lobCode);





    /*
    @GetMapping("/Lob/{lobDescription}")
    public Lob findLobByLobDescription(@PathVariable String lobDescription){
        return service.getLobByLobDescription(lobDescription);
    }
    @GetMapping("/Lob/{shortDescription}")
    public Lob findLobByLobShortDescription(@PathVariable String lobShortDescription){
        return service.getLobByLobShortDescription(lobShortDescription);
    }
    @GetMapping("/Lob/{lobUrl}")
    public Lob findLobByLobUrl(@PathVariable String lobUrl){
        return service.getLobByLobUrl(lobUrl);
    }
    @GetMapping("/Lob/{descriptionLink}")
    public Lob findLobByLobDescriptionByLink(@PathVariable String lobDescriptionByLink){
        return service.getLobByLobDescriptionByLink(lobDescriptionByLink);
    }
    @GetMapping("/Lob/{effectiveFromDate}")
    public Lob findLobByLobEffectiveFromDate(@PathVariable Date lobEffectiveFromDate){
        return service.getLobByLobEffectiveFromDate((java.sql.Date) lobEffectiveFromDate);
    }
    @GetMapping("/Lob/{effectiveTill}")
    public Lob getLobByLobEffectiveTill(@PathVariable Date lobEffectiveTill){
        return  service.getLobByLobEffectiveTill((java.sql.Date) lobEffectiveTill);
    }
*/
    @PutMapping("/update")
    public ResponseEntity<Object> Update(@RequestBody Lob lob){
        try{
            Lob result = service.saveLob(lob);
            if(result==null){
                throw new RecordNotFoundException("Record_Not_Found");
            }
            return ResponseHandler.generateResponse("updated",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
   // public Lob updateLob(@RequestBody Lob lob){
    //    return service.saveLob(lob);
   // }

    @DeleteMapping("/delete/{lobCode}")
    public ResponseEntity<Object> Delete(@PathVariable String lobCode){
        try{
            String result = service.deleteLob(lobCode);
            if(result==null){
                throw new RecordNotFoundException("Record_Not_Found");
            }
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
            //return ErrorResponse();
        }
    }
   //public String deleteLob(@PathVariable String lobCode){
   //     return service.deleteLob(lobCode);
  //  }

}
