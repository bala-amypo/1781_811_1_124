@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileService service;

    @PostMapping
    public StudentProfile createOrUpdate(
            @RequestBody StudentProfile profile) {
        return service.createOrUpdateProfile(profile);
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return service.getProfileById(id);
    }

    @GetMapping
    public List<StudentProfile> getAll() {
        return service.getAllProfiles();
    }
}
