package healthcalc;

public class ParameterValueCausesOverflow extends RuntimeException {

	private static final long serialVersionUID = 1L;

/**
   * Exception thrown when the value of the parameter of the {@link Factorial#compute} method is too
   * high and can cause overflow, thus giving an unexpected result.
   *
   * @param errorMessage
   */
  public ParameterValueCausesOverflow(String errorMessage) {
    super(errorMessage) ;
  }
}