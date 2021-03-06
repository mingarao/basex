package org.basex.core.cmd;

import static org.basex.core.Text.*;

import org.basex.core.*;
import org.basex.core.parse.*;
import org.basex.core.parse.Commands.Cmd;
import org.basex.core.parse.Commands.CmdCreate;
import org.basex.util.*;

/**
 * Evaluates the 'create user' command and creates a new user.
 *
 * @author BaseX Team 2005-14, BSD License
 * @author Christian Gruen
 */
public final class CreateUser extends AUser {
  /**
   * Default constructor.
   * @param name user name
   * @param pw password
   */
  public CreateUser(final String name, final String pw) {
    super(name, pw);
  }

  @Override
  protected boolean run() {
    try {
      create(args[0], args[1], context);
      return info(USER_CREATED_X, args[0]);
    } catch(final BaseXException ex) {
      return error(Util.message(ex));
    }
  }

  @Override
  public void build(final CmdBuilder cb) {
    cb.init(Cmd.CREATE + " " + CmdCreate.USER).args();
  }

  /**
   * Creates a new user.
   * @param user user name
   * @param pass password
   * @param ctx database context
   * @throws BaseXException database exception
   */
  private static void create(final String user, final String pass, final Context ctx)
      throws BaseXException {

    if(!Databases.validName(user)) throw new BaseXException(NAME_INVALID_X, user);
    if(!isMD5(pass)) throw new BaseXException(PW_NOT_VALID);
    if(!ctx.users.create(user, pass)) throw new BaseXException(USER_EXISTS_X, user);
  }
}
