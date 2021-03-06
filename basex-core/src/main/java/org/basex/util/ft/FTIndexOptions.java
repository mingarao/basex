package org.basex.util.ft;

import org.basex.util.options.*;

/**
 * Full-text index options.
 *
 * @author BaseX Team 2005-14, BSD License
 * @author Christian Gruen
 */
public class FTIndexOptions extends Options {
  /** Option: wildcards. */
  public static final EnumOption<FTMode> MODE = new EnumOption<FTMode>("mode", FTMode.ANY);
  /** Option: fuzzy. */
  public static final BooleanOption FUZZY = new BooleanOption("fuzzy", false);
  /** Option: wildcards. */
  public static final BooleanOption WILDCARDS = new BooleanOption("wildcards", false);
  /** Option: ordered. */
  public static final BooleanOption ORDERED = new BooleanOption("ordered", false);
  /** Option: distance. */
  public static final OptionsOption<FTDistanceOptions> DISTANCE =
      new OptionsOption<FTDistanceOptions>("distance", FTDistanceOptions.class);
  /** Option: window. */
  public static final OptionsOption<FTWindowOptions> WINDOW =
      new OptionsOption<FTWindowOptions>("window", FTWindowOptions.class);
  /** Option: scope. */
  public static final OptionsOption<FTScopeOptions> SCOPE =
      new OptionsOption<FTScopeOptions>("scope", FTScopeOptions.class);
  /** Option: content. */
  public static final EnumOption<FTContents> CONTENT =
      new EnumOption<FTContents>("content", FTContents.class);
}
