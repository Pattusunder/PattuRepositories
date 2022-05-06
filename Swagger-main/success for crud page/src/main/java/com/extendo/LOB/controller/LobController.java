package com.extendo.LOB.controller;

import com.extendo.LOB.ErrorResponse.ErrorHandler;
import com.extendo.LOB.ErrorResponse.RecordNotFoundException;
import com.extendo.LOB.entity.Lob;
import com.extendo.LOB.dto.APIResponse;
import com.extendo.LOB.response.ResponseHandler;
import com.extendo.LOB.service.LobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.Valid;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class LobController {
    @Autowired
    private LobService service;

    @GetMapping
    public APIResponse<List<Lob>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "lobCode") String sortBy)
    {
        List<Lob> list = service.getAllEmployees(pageNo, pageSize, sortBy);
        return new APIResponse<>(list.size(),list);
    }

    @PostMapping("/addLob")
    public ResponseEntity<Object> Post(@Valid @RequestBody Lob lob){
        try{
           Lob result = service.saveLob(lob);
           return ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping("/Lobs")
    public APIResponse<List<Lob>> Get(){
            List<Lob> result = (List<Lob>) service.getLobs();
            return new APIResponse<List<Lob>>(result.size(),result);
        //try {
           // if(result==null){
           //     throw new RecordNotFoundException("Record_Not_Found");
         //   }
         //   return  ResponseHandler.generateResponse("Successfully retrieved Data!",HttpStatus.OK,result);
      //  }catch(Exception e){

          //  return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        //}

    }

    @GetMapping("/Lobs/{lobCode}")
    public ResponseEntity<Object> Get(@PathVariable String lobCode) {
try{
    Lob result =  this.service.getLobByLOBCode(lobCode);
    if(result==null){
        throw new RecordNotFoundException("Record_Not_Found");
    }
    return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
}catch(RecordNotFoundException e){
    return ErrorHandler.ErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST);
}

    }

    @PutMapping("/update")
    public ResponseEntity<Object> Update(@Valid @RequestBody Lob lob){
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

        }
    }


}
