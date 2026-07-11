# Contributing to Monsoon Mitra

Thank you for your interest in contributing to the Monsoon Mitra project! This document provides guidelines and instructions for contributing.

## Code of Conduct

Please be respectful and professional in all interactions. We are committed to providing a welcoming and inclusive environment for all contributors.

## Getting Started

1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/your-username/MonsoonCare.git
   cd MonsoonCare
   ```
3. **Create a branch** for your changes:
   ```bash
   git checkout -b feature/your-feature-name
   ```

## Development Guidelines

### Code Style
- Follow Java naming conventions (camelCase for variables and methods)
- Use meaningful variable and function names
- Add comments for complex logic
- Maximum line length: 120 characters
- Use 4 spaces for indentation (not tabs)

### Project Structure
```
├── ui/
│   ├── activities/       # Activity classes only
│   ├── adapters/         # RecyclerView adapters
│   └── fragments/        # Fragment classes
├── data/
│   ├── models/           # Data model classes
│   ├── repository/       # Repository pattern
│   └── db/               # Database setup
├── services/             # Background services
├── network/              # API and networking
├── utils/                # Utility classes
└── viewmodels/           # ViewModel classes
```

### Naming Conventions

#### Classes
- Activity: `*Activity` (e.g., `MainActivity`)
- Fragment: `*Fragment` (e.g., `WeatherFragment`)
- Adapter: `*Adapter` (e.g., `AlertAdapter`)
- ViewModel: `*ViewModel` (e.g., `DashboardViewModel`)
- Repository: `*Repository` (e.g., `WeatherRepository`)
- Service: `*Service` (e.g., `LocationUpdateService`)

#### Methods
- Getters: `get*()` (e.g., `getWeatherData()`)
- Setters: `set*()` (e.g., `setLocation()`)
- Callbacks: `on*()` (e.g., `onSuccess()`)

#### XML Resources
- Layouts: `activity_*, fragment_*, item_*`
- Drawables: `ic_*, bg_*`
- Strings: Use descriptive keys (e.g., `alert_heavy_rain`)

### Architecture Principles

- **MVVM Pattern**: Use ViewModels for business logic
- **Repository Pattern**: Abstract data access
- **Dependency Injection**: Use constructor injection
- **Reactive Programming**: Use LiveData and Coroutines
- **Clean Code**: Follow SOLID principles

### Testing Requirements

All new features should include:
- ✅ Unit tests for business logic
- ✅ Integration tests for repository layer
- ✅ UI tests for Activities/Fragments
- ✅ Minimum 80% code coverage

### Documentation

- Add JavaDoc comments for public methods
- Include TODO comments for future improvements
- Update README.md for new features
- Add inline comments for complex logic

```java
/**
 * Fetches weather data for the given location
 * @param latitude The latitude of the location
 * @param longitude The longitude of the location
 * @param language The preferred language code
 * @return LiveData containing weather information
 */
public LiveData<Weather> getWeather(double latitude, double longitude, String language) {
    // Implementation
}
```

## Commit Messages

Follow the conventional commits format:

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types
- `feat`: A new feature
- `fix`: A bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring without feature/fix changes
- `test`: Adding or updating tests
- `chore`: Build, dependencies, or tooling changes

### Examples
```
feat(weather): add 7-day forecast display
fix(alerts): correct alert filtering by severity
docs(readme): update setup instructions
test(preparedness): add unit tests for plan generation
```

## Pull Request Process

1. **Update your branch** with the latest `main`:
   ```bash
   git fetch origin
   git rebase origin/main
   ```

2. **Run tests locally**:
   ```bash
   ./gradlew test
   ./gradlew connectedAndroidTest
   ```

3. **Build the project**:
   ```bash
   ./gradlew build
   ```

4. **Push your changes**:
   ```bash
   git push origin feature/your-feature-name
   ```

5. **Create a Pull Request** with:
   - Clear title describing the change
   - Detailed description of changes
   - Reference to related issues (e.g., `Closes #123`)
   - Screenshots if UI changes are included
   - Test results confirming all tests pass

### PR Template
```markdown
## Description
Briefly describe the changes made.

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Related Issue
Closes #(issue number)

## Testing
- [ ] Unit tests added/updated
- [ ] Integration tests added/updated
- [ ] UI tests added/updated
- [ ] All tests passing

## Screenshots (if applicable)
Include before/after screenshots for UI changes.

## Checklist
- [ ] Code follows style guidelines
- [ ] Self-review completed
- [ ] Comments added for complex logic
- [ ] Documentation updated
- [ ] No breaking changes
```

## Security Considerations

- Never commit API keys or sensitive data
- Use `.gitignore` to exclude sensitive files
- Review security before submitting PR
- Follow OWASP security guidelines
- Use HTTPS for all API communications
- Implement input validation

## Performance Considerations

- Aim for app startup time < 2 seconds
- Memory usage < 100MB on low-end devices
- Network requests should have timeouts
- Use appropriate caching strategies
- Optimize images before committing

## Testing Checklist

- ✅ App runs without crashes
- ✅ All permissions handled correctly
- ✅ Features work on min SDK (Android 7.0+)
- ✅ Features work on target SDK (Android 14)
- ✅ No memory leaks
- ✅ Proper error handling
- ✅ Meaningful error messages

## Issue Reporting

When reporting issues, please include:
1. **Device Information**: Model, OS version, RAM
2. **Steps to Reproduce**: Exact steps to trigger the issue
3. **Expected Behavior**: What should happen
4. **Actual Behavior**: What actually happens
5. **Logs**: Relevant error logs or stack traces
6. **Screenshots**: Visual references when applicable

## Feature Requests

When suggesting features, include:
1. **Use Case**: Why this feature is needed
2. **Proposed Solution**: How it should work
3. **Alternative Approaches**: Other possible solutions
4. **Impact**: How it affects existing features

## Resources

- [Android Development Documentation](https://developer.android.com/)
- [MVVM Pattern Guide](https://developer.android.com/jetpack/guide)
- [Room Database Docs](https://developer.android.com/training/data-storage/room)
- [Retrofit Documentation](https://square.github.io/retrofit/)
- [LiveData Guide](https://developer.android.com/topic/libraries/architecture/livedata)

## Questions?

Feel free to open an issue or contact the development team at: dev@monsooncares.com

---

**Thank you for contributing to Monsoon Mitra!** Your efforts help make the application safer and more helpful for communities during monsoon season.

