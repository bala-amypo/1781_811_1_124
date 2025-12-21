@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService service;

    @PostMapping
    public AssessmentResult record(
            @RequestBody AssessmentResult result) {
        return service.recordAssessment(result);
    }
}
