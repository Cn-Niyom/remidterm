package sit.remidterm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import sit.remidterm.exceptions.ErrorResponse;
import sit.remidterm.service.FileService;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileService.loadFileAsResource(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
    }

    @PostMapping("")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return "You successfully uploaded " + file.getOriginalFilename() + "!";
    }

    @DeleteMapping("/{filename:.+}")
    public String deleteFile(@PathVariable String filename) {

        return fileService.removeResource(filename);

    }

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleFileNotFound(Exception ex, WebRequest request) {
        ErrorResponse er = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getDescription(false).substring(4));
        er.addValidationError("Field 1", "error 1");
        er.addValidationError("Field 2", "error 2");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(NullPointerException.class)
    public RuntimeException handleNullPointer(RuntimeException exception) {
        return exception;
    }

    @ExceptionHandler(NumberFormatException.class)
    public RuntimeException handleNumberFormat(RuntimeException exception) {
        return exception;
    }
}




